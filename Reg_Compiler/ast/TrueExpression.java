package ast;

import java.util.List;
import java.util.HashMap;

public class TrueExpression
   extends AbstractExpression
{
   public TrueExpression(int lineNum)
   {
      super(lineNum);
   }



   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      return "bool";
   }

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      return new VT("1", "i64");
   }

   public String getID()
   {
      return "not good";
   }
   public String pointerOrNum(HashMap<String, String> structVarMap)
    {
      return "i64";
    }
}
