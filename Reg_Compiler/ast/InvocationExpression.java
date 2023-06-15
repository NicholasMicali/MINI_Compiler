package ast;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class InvocationExpression
   extends AbstractExpression
{
   private final String name;
   private final List<Expression> arguments;

   public InvocationExpression(int lineNum, String name,
      List<Expression> arguments)
   {
      super(lineNum);
      this.name = name;
      this.arguments = arguments;
   }

 

   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      Type func = symbolTable.get(name);
      if (func == null){
         System.out.println("Error: func " + name + " is not defined");
         return "null";
      }
      String funcString = func.typeString();
      if (funcString != "function"){
         System.out.println("Error: invocation of non function type at line: " + lineNum);

      }
      FunctionType funcType = FunctionType.class.cast(func);
      if (funcType.params.size() != arguments.size())
      {
         System.out.println("Error: wrong number of arguments for function innvocation at line: " + lineNum);
         return funcType.retType.typeString();
      }
      int i = 0;
      while (i < funcType.params.size())
      {
         String arg = arguments.get(i).typeCheck(typeTable, symbolTable, localTable);
         String par = funcType.params.get(i).typeString();

         if ((par == "int") || (par == "bool")){
            if (par != arg)
            {
               System.out.println("Error: wrong argument types for function innvocation at line: " + lineNum);
               return funcType.retType.typeString();
            }
         }
         else if (!((par.equals(arg)) || ((par == "null") && (arg != "int") && (arg != "bool")) || 
                                        ((arg == "null") && (par != "int") && (par != "bool"))))
         {
            System.out.println("Error: wrong argument types for function innvocation at line: " + lineNum);
            return funcType.retType.typeString();
         }
         i++;
      }
      return funcType.retType.typeString();
   }

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      List<String> args = new ArrayList<String>();
      for (Expression a : arguments)
      {
         VT argVT = a.llvm(instructions, counter, structList, varMap, curr);
         args.add(argVT.Reg);
      }
      String result = "null";
      String retType = varMap.get(name).ty;//structVarMap.get(name);
      if (retType != null)
      {
         if (retType.equals("void"))
         {
            instructions.add(new InvocationVInstruction(name, args, structList.get(name)));
            return new VT(result, "void");
         }
         result = counter.newReg();
         instructions.add(new InvocationInstruction(result, retType, name, args, structList.get(name)));
         return new VT(result, retType);
      }
      result = counter.newReg();
      instructions.add(new InvocationInstruction(result, "i64", name, args, structList.get(name)));
      return new VT(result, "i64");
   }

   public String getID()
   {
      return "not good";
   }

   public String pointerOrNum(HashMap<String, String> structVarMap)
   {
      return "na";//structVarMap.get(name);
   }

}
