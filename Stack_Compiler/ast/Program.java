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
      for (ast.Function func : this.funcs)
      {
         //symbolTable.put(func.name, Function); add a new type that look like this: ([Params] => retType)
         symbolTable = func.addType(typeTable, symbolTable);
         func.typeCheck(typeTable, symbolTable);
      }
   }

   public void controlFlow()
   {
      List<BasicBlock> blocks;
      List<Instruction> instructions = new ArrayList<Instruction>();
      RegisterC counter = new RegisterC();
      LabelCounter labelC = new LabelCounter();
      HashMap<String, List<Declaration>> structList = new HashMap<String, List<Declaration>>();
      HashMap<String, String> structVarMap = new HashMap<String, String>();
      List<String> globs = new ArrayList<String>();

      for (TypeDeclaration ty : types)
      {
         ty.llvm(instructions, counter);
         ty.llvmSList(structList);
         ty.mapstructs(structVarMap);
      }
      for (Declaration dec : decls)
      {
         //dec.llvmGlob(instructions);
         dec.llvmGlob(instructions, counter, globs);
         dec.mapstructs(structVarMap);

      }
      List<String> pNames = new ArrayList<String>();
      try {
         FileWriter writer = new FileWriter("output.cfgs");
         for (ast.Function func : this.funcs)
         {
            pNames = new ArrayList<String>();
            blocks = new ArrayList<BasicBlock>();
            String retType = func.retType.llvmType();
            blocks = func.controlFlow(blocks, labelC);
            func.maprets(structVarMap);
            func.mapargs(structList);
            func.llvm(instructions);
            writer.write(func.name + ":\n");
            HashMap<String, String> structVarMapLocal = new HashMap<String, String>(structVarMap);
            for (BasicBlock block : blocks)
            {
               if (block == null){
                  //System.out.println("no block");
                  //return;
               }
               else{
                  block.printBlock(writer);
                  block.llvm(instructions, counter, structList, structVarMapLocal, pNames, retType, globs);
               }
            }
         }
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
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
}
