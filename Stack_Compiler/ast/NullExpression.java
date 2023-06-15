package ast;

import java.util.List;
import java.util.HashMap;

public class NullExpression
   extends AbstractExpression
{
   public NullExpression(int lineNum)
   {
      super(lineNum);
   }



   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      return "null";
   }

   public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      return "null";
   }

   public String getID()
   {
      return "not good";
   }
   public String pointerOrNum(HashMap<String, String> structVarMap)
    {
      return "null";
    }
}
