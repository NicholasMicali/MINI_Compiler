package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class InvocationStatement
   extends AbstractStatement
{
   private final Expression expression;

   public InvocationStatement(int lineNum, Expression expression)
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
      expression.typeCheck(typeTable, symbolTable, localTable);
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      entry.lines.add(this);
      return entry;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {

      expression.llvm(instructions, counter, params, structList, structVarMap, globs);
      return;
   }
}
