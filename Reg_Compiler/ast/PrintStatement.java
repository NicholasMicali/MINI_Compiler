package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PrintStatement
   extends AbstractStatement
{
   private final Expression expression;

   public PrintStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public boolean returnCheck(boolean isVoid)
   {
      return false;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      String expr = expression.typeCheck(typeTable, symbolTable, localTable);
      if (expr == "void")
      {
         System.out.println("Error: printing void statement at line: " + lineNum);
      }
   }


   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      entry.lines.add(this);
      return entry;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      VT result = expression.llvm(instructions, counter, structList, varMap, curr);
      instructions.add(new PrintInstruction(result.Reg, false));
      return;
   }
}
