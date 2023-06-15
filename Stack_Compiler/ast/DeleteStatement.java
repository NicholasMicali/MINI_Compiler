package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DeleteStatement
   extends AbstractStatement
{
   private final Expression expression;

   public DeleteStatement(int lineNum, Expression expression)
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

      if (typeTable.get(expr) == null)
      {
         System.out.println("Error: delete statment contains non struct type at line: " + lineNum);
      }
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      entry.lines.add(this);
      return entry;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      String ltype = "%struct." + structVarMap.get(expression.getID()) + "*";
      //instructions.add(new LoadInstruction(lResult, ltype, ltype, "%" + expression.getID()));
      String lResult = expression.llvm(instructions, counter, params, structList, structVarMap, globs);
      String bResult = counter.newReg();
      instructions.add(new BitInstruction(bResult, "bitcast", ltype, lResult, "i8*"));
      instructions.add(new FreeInstruction(bResult));
      return;
   }
}
