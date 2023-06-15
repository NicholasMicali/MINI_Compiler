package ast;

import java.util.List;
import java.util.HashMap;

public class NewExpression
   extends AbstractExpression
{
   private final String id;

   public NewExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }


   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      //findtype and if not a struct then error.
      if (typeTable.get(id) == null)
      {
         System.out.println("Error: New statment contains non struct type at line: " + lineNum);
      }
      return id;
   }

   public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
     return "null";
   }

   public String getID()
   {
      return id;
   }

   public String pointerOrNum(HashMap<String, String> structVarMap)
   {
      return "%struct." + id + "*";
   }
}
