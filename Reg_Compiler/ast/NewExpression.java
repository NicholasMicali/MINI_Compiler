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

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      
     return new VT("newexp", "newexp");
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
