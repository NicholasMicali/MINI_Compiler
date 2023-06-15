package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;


public class Program
{
   private final List<TypeDeclaration> types;
   private final List<Declaration> decls;
   private final List<Function> funcs;

   public Program(List<TypeDeclaration> types, List<Declaration> decls,
      List<Function> funcs)
   {
      this.types = types;
      this.decls = decls;
      this.funcs = funcs;
   }

   public void returnCheck() 
   {
      for (ast.Function func : this.funcs)
      {
         func.returnCheck();
      }
   }

   public void typeCheck()
   {

      HashMap<String, HashMap<String, Type>> typeTable = new HashMap<String, HashMap<String, Type>>();
      HashMap<String, Type> symbolTable = new HashMap<String, Type>();
      //add all the structs to the type hashmap

      for (ast.TypeDeclaration struct : this.types)
      {
         typeTable.put(struct.name, new HashMap<String, Type>());
         // add each field to the inner hashmap
         for (Declaration attribute : struct.fields)
         {

            typeTable.get(struct.name).put(attribute.name, attribute.type);
         }
      }

      //add all the global variables to a symbol table
      for (ast.Declaration globalVariable : this.decls)
      {
         symbolTable.put(globalVariable.name, globalVariable.type);
      }
      //call typeCheck on each function, pass the global tables down
      for (ast.Function func : this.funcs)
      {
         //symbolTable.put(func.name, Function); add a new type that look like this: ([Params] => retType)
         symbolTable = func.addType(typeTable, symbolTable);
         func.typeCheck(typeTable, symbolTable);
      }
   }

   public void controlFlow(Boolean cp, Boolean lv)
   {
      List<BasicBlock> blocks;
      List<Instruction> instructions = new ArrayList<Instruction>();
      RegisterC counter = new RegisterC();
      LabelCounter labelC = new LabelCounter();
      HashMap<String, List<Declaration>> structList = new HashMap<String, List<Declaration>>();
      HashMap<String, VT> varMap = new HashMap<String, VT>();

      for (TypeDeclaration ty : types)
      {
         ty.llvm(instructions, counter);
         ty.llvmSList(structList);
      }
      for (Declaration dec : decls)
      {
         dec.llvmGlob(instructions, counter, varMap);
      }
      try {
         FileWriter writer = new FileWriter("output.cfgs");
         for (ast.Function func : this.funcs)
         {
            func.maprets(varMap);
            HashMap<String, VT> localVarMap = new HashMap<String, VT>(varMap);
            blocks = new ArrayList<BasicBlock>();
            String retType = func.retType.llvmType();
            blocks = func.controlFlow(blocks, labelC);
            Boolean fb = true;
            
            func.mapargs(structList);
            func.llvm(instructions);
            writer.write(func.name + ":\n");
            for (BasicBlock block : blocks)
            {
               
               if (block.decs != null){
                  block.maplocals(instructions, counter, localVarMap);
               }
               if (block.params != null){
                  HashMap<String, VT> paramVarMap = new HashMap<String, VT>(localVarMap);
                  block.mapparams(instructions, counter, paramVarMap);
                  block.addparams(instructions, counter, localVarMap);
                  block.printBlock(writer);
                  block.llvm(instructions, counter, structList, retType, paramVarMap);
               }
               else{
                  block.printBlock(writer);
                  block.llvm(instructions, counter, structList, retType, localVarMap);
               }
            }


            //////// seal phi
            for (BasicBlock block : blocks)
            {
               block.sealPhi(instructions, counter, blocks);
            }


            ///////// remove trivial phi
            List<PhiInstruction> trivialPhis = new ArrayList<PhiInstruction>();
            Boolean firstT = true;
            while ((trivialPhis.size() > 0) || firstT)
            {
               trivialPhis = new ArrayList<PhiInstruction>();
               firstT = false;
               for (Instruction inst : instructions)
               {
                  if (inst.getClass().equals(PhiInstruction.class))
                  {
                     PhiInstruction pInst = (PhiInstruction)inst;
                     if (pInst.trivial())
                     {
                        trivialPhis.add(pInst);
                     }
                  }
               }
               for (PhiInstruction pInst : trivialPhis)
               {
                  instructions.remove(pInst);
                  String phiReg = pInst.result;
                  String newReg = pInst.getReg();
                  if (newReg.equals("unresolved phi"))
                  {
                     newReg = "%r25";
                  }
                  for (Instruction inst : instructions)
                  {
                     inst.trivialChange(phiReg, newReg);
                  }
               }
            }
         }
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

      ////////// constant propogation
      if (cp){
            ArrayList<ArrayList<Instruction>> functionInsts = new ArrayList<ArrayList<Instruction>>();
            ArrayList<Instruction> currentList = new ArrayList<Instruction>();
            Boolean firstFunc = false;
            for (Instruction inst : instructions)
            {
               if (inst.getClass().equals(FunctionDefInstruction.class)) {
                  if (firstFunc)
                  {
                     functionInsts.add(currentList);
                  }
                  firstFunc = true;
                  currentList = new ArrayList<Instruction>();
                  currentList.add(inst);
               }
               else if (firstFunc)
               {
                 currentList.add(inst);
               }
            }
            functionInsts.add(currentList);

            for (ArrayList<Instruction> insts : functionInsts)
            {
               List<String> worklist = new ArrayList<String>();
               HashMap<String, String> cVals = new HashMap<String, String>();
               for (Instruction inst : insts)
               {
                  if (inst instanceof FunctionDefInstruction) {
                     FunctionDefInstruction fi = (FunctionDefInstruction)inst;
                     fi.paramsMap(cVals, worklist);
                  }
                  inst.propEval(worklist, cVals); // should add value to cVals map
               }
               while (worklist.size() > 0)
               {
                  String reg = worklist.get(0);
                  worklist.remove(reg);
                  for (Instruction inst : insts)
                  {
                     inst.propChange(worklist, cVals, reg); // if reg is used, update map and worklist
                  }
               }
               for (Instruction inst : insts)
               {
                  inst.writeUse(cVals);
               }
               //Write uses
            }

         this.UCElimination(instructions);
            
      }
      ///////////// local value numbering
      if(lv){
         HashMap<LocalV, String> valueMap = new HashMap<LocalV, String>();
         RegisterC valCounter = new RegisterC();
         HashMap<String, String> replaced = new HashMap<String, String>();
         for (Instruction inst : instructions)
         {
            if (inst instanceof LabelInstruction)
            {
               for (LocalV local : valueMap.keySet())
               {
                  String val = valueMap.get(local);
                  if (local.op.equals("var")){
                     for (LocalV otherLocal : valueMap.keySet())
                     {
                        String otherVal = valueMap.get(otherLocal);
                        if ((!(otherLocal.op.equals("var"))) && (otherVal.equals(val)))
                        {
                           replaced.put(local.result, otherLocal.result);
                        }
                     }
                  }
               }
               valueMap = new HashMap<LocalV, String>();
               valCounter = new RegisterC();
            }
            else {
               inst.lvMap(valueMap, valCounter);
            }
         }
         for (String reg : replaced.keySet())
         {
            String newReg = replaced.get(reg);
            for (Instruction inst : instructions)
            {
               inst.trivialChange(reg, newReg);
            }
         }
      }

      this.UCElimination(instructions);




      ///////////// print llvm
      try {

         FileWriter writer = new FileWriter("output.ll");
         Boolean first = false;
         for (Instruction inst : instructions)
         {
            if (inst.getClass() == FunctionDefInstruction.class)
            {
               if (first)
               {
                  writer.write("}\n");
                  writer.write("\n");
               }
               else {
                  first = true;
               }
            }
            inst.printInst(writer);
         }
         writer.write("}\n");
         writer.write("\n");
         writer.write("declare i8* @malloc(i64)\n");
         writer.write("declare void @free(i8*)\n");
         writer.write("declare i64 @printf(i8*, ...)\n");
         writer.write("declare i64 @scanf(i8*, ...)\n");
         writer.write("@.println = private unnamed_addr constant [5 x i8] c\"%ld\\0A\\00\", align 1\n");
         writer.write("@.print = private unnamed_addr constant [5 x i8] c\"%ld \\00\", align 1\n");
         writer.write("@.read = private unnamed_addr constant [4 x i8] c\"%ld\\00\" , align 1\n");
         writer.write("@.read_scratch = common global i64 0, align 4\n");
         writer.write("\n");

         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void UCElimination(List<Instruction> instructions)
   {
      /// useless code elimination
      boolean firstPass = true;
      List<Instruction> marked = new ArrayList<Instruction>();
      while ((marked.size() > 0) || firstPass)
      {
         firstPass = false;
         //sweep
         for (Instruction inst : marked)
         {
            instructions.remove(inst);
         }
         marked = new ArrayList<Instruction>();
         for (Instruction inst : instructions)
         {
            inst.useless(instructions, marked); // for given instruction, see if ever used, add to marked
         }
      }
   }
}
