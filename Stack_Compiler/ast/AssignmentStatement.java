package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentStatement
   extends AbstractStatement
{
   private final Lvalue target;
   private final Expression source;

   public AssignmentStatement(int lineNum, Lvalue target, Expression source)
   {
      super(lineNum);
      this.target = target;
      this.source = source;
   }

   public boolean returnCheck(boolean isVoid)
   {
      return false;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      //Type assignment = source.typeCheck(typeTable, symbolTable, localTable);
      
      String variable = target.typeCheck(typeTable, symbolTable, localTable);
      String value = source.typeCheck(typeTable, symbolTable, localTable);
      
      if ((variable == "int") || (variable == "bool")){
         if (variable != value)
         {
            System.out.println("Error: Type of assingment does not match the variable at line: " + lineNum);
         }
      }
      else if (!((variable.equals(value)) || ((variable == "null") && (value != "int") && (value != "bool")) || 
                                        ((value == "null") && (variable != "int") && (variable != "bool"))))
      {
         System.out.println("Error: Type of assingment does not match the variable at line: " + lineNum);
      }
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      entry.lines.add(this);
      return entry;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      //System.out.println(target);
      String targetName = target.llvm(instructions, counter, params, structList, structVarMap, globs);
      String result;
      if (source.getClass().equals(ReadExpression.class))
      {
         instructions.add(new ReadInstruction(targetName));
         return;
      }
      if (source.getClass().equals(NewExpression.class))
      {
         //%u11 = call i8* @malloc(i64 24)
	      //%u12 = bitcast i8* %u11 to %struct.foo*
         String mResult = counter.newReg();
         instructions.add(new MallocInstruction(mResult, "i8*", structList.get(source.getID()).size() * 8 + ""));
         result = counter.newReg();
         instructions.add(new BitInstruction(result, "bitcast", "i8*", mResult, "%struct." + source.getID() + "*"));
      }
      else{
         result = source.llvm(instructions, counter, params, structList, structVarMap, globs);
      }
      String targetType = target.llvmType(structVarMap, structList);
      
      instructions.add(new StoreInstruction(targetType, result, targetType, targetName));
      return;
   }
}
