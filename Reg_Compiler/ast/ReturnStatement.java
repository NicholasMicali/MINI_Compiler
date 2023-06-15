package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ReturnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public ReturnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public boolean returnCheck(boolean isVoid)
   {
      return true;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      String returnType = expression.typeCheck(typeTable, symbolTable, localTable);
      String retTypeString = retType.typeString();
      if ((retTypeString == "int") || (retTypeString == "bool")){
         if (returnType != retTypeString)
         {
            System.out.println("Error: return statement does not match the function return type at line: " + lineNum);
         }
      }
      else if (returnType.equals("null"))
      {
         
      }
      else if (!(returnType.equals(retTypeString)))
      {
         System.out.println("Error: return statement does not match the function return type at line: " + lineNum);
      }
   }


   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      entry.lines.add(this);
      entry.nextL = funcExit;
      funcExit.prev.add(entry);
      blocks.add(entry);
      return funcExit;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      VT result = expression.llvm(instructions, counter, structList, varMap, curr);
      instructions.add(new ReturnInstruction("i64", result.Reg));
      return;
   }



   public void llvmRET(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, String retType, HashMap<String, VT> varMap, BasicBlock curr)
   {
      VT result = expression.llvm(instructions, counter, structList, varMap, curr);
      instructions.add(new ReturnInstruction(retType, result.Reg));
      return;
   }
}
