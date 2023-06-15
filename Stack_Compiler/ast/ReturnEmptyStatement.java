package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ReturnEmptyStatement
   extends AbstractStatement
{
   public ReturnEmptyStatement(int lineNum)
   {
      super(lineNum);
   }

   public boolean returnCheck(boolean isVoid)
   {
      return true;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      String retTypeString = retType.typeString();
      if (retTypeString != "void")
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
      return null;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      instructions.add(new ReturnVInstruction());
      return;
   }
}
