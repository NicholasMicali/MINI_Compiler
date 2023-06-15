package ast;

import java.util.List;
import java.util.HashMap;

public class IntegerExpression
   extends AbstractExpression
{
   private final String value;

   public IntegerExpression(int lineNum, String value)
   {
      super(lineNum);
      this.value = value;
   }



   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      return "int";
   }

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      return new VT(value, "i64");
   }

   public String getID()
   {
      return "i64";
   }

   public String pointerOrNum(HashMap<String, String> structVarMap)
    {
      return "i64";
    }
}
