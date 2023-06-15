package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Function
{
   private final int lineNum;
   public final String name;
   public final Type retType;
   private final List<Declaration> params;
   private final List<Declaration> locals;
   private final Statement body;

   public Function(int lineNum, String name, List<Declaration> params,
      Type retType, List<Declaration> locals, Statement body)
   {
      this.lineNum = lineNum;
      this.name = name;
      this.params = params;
      this.retType = retType;
      this.locals = locals;
      this.body = body;
   }

   public void returnCheck() 
   {
      boolean isVoid = retType.typeString() == "void";
      if (!body.returnCheck(isVoid))
      {
         if (isVoid)
         {
            System.out.println("Error: function (" + name + ") returns in some branch");
         }
         else {
            System.out.println("Error: function (" + name + ") does not return in all branches");
         }
      }
   }

   public HashMap<String, Type> addType(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable)
   {
      List<Type> paramsTypes = new ArrayList<Type>();
      for (Declaration dec : params)
      {
         paramsTypes.add(dec.type);
      }
      Type func = new FunctionType(name, paramsTypes, retType);
      symbolTable.put(name, func);
      return symbolTable;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable)
   {
      HashMap<String, Type> localTable = new HashMap<String, Type>();
      for (Declaration dec : params)
      {
         localTable.put(dec.name, dec.type);
      }
      for (Declaration dec : locals)
      {
         localTable.put(dec.name, dec.type);
      }
      body.typeCheck(typeTable, symbolTable, localTable, retType);
   }


   public List<BasicBlock> controlFlow(List<BasicBlock> blocks, LabelCounter labelC)
   {
      //System.out.println(name + ":");
      BasicBlock entry = new BasicBlock(labelC.newLabel(), null, null, null);
      BasicBlock exit = new BasicBlock("exit", null, null, null);
      List<Declaration> decs = new ArrayList<Declaration>();
      List<Declaration> prms = new ArrayList<Declaration>();
      prms.addAll(params);
      decs.addAll(locals);
      entry.params = prms;
      entry.decs = decs;
      BasicBlock result = body.controlFlow(blocks, entry, exit, exit, labelC);
      blocks.add(result);
      //System.out.println("added fun exit");
      return blocks;
   }

   public void llvm(List<Instruction> instructions)
   {
      List<String> paramTypes = new ArrayList<String>();
      List<String> paramNames = new ArrayList<String>();
      for (Declaration param : params)
      {
         paramTypes.add(param.typeDec());
         paramNames.add(param.name);

      }
      instructions.add(new FunctionDefInstruction(retType.llvmType(), "@" + name, paramTypes, paramNames));
      //instructions.add(new AllocaInstruction("%retval", "i64"));
   }

   public void maprets(HashMap<String, VT> varMap)
   {
      varMap.put(name, new VT("function", retType.llvmType()));
   }

   public void mapargs(HashMap<String, List<Declaration>> structList)
   {
      structList.put(name, params);
   }
}
