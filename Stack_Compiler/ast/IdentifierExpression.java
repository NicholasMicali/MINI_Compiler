package ast;

import java.util.List;
import java.util.HashMap;

public class IdentifierExpression
   extends AbstractExpression
{
   private final String id;

   public IdentifierExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }


   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      Type var = localTable.get(id);
      if (var == null)
      {
         var = symbolTable.get(id);
         if (var == null)
         {
            System.out.println("Error: variable not found: " + id);
         }
      }
      String variable = var.typeString();
      return variable;
   }

   public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      String result = counter.newReg();
      //String ty = structVarMap.get(id);
      String ty = structVarMap.get("L_" + id);
      if (ty == null)
      {
         ty = structVarMap.get(id);
      }
      String tyExtended = "i64";
      if (ty != null)
      {
         tyExtended = "%struct." + ty + "*";
         if (ty.equals("int") || ty.equals("bool"))
         {
            tyExtended = "i64";
         }
      }
      if (params.contains(id))
      {
         instructions.add(new LoadInstruction(result, tyExtended, tyExtended, "%P_" + id));
         return result;
      }
      else if (globs.contains(id))
      {
         instructions.add(new LoadInstruction(result, tyExtended, tyExtended, "@" + id));
         return result;
      }
      //System.out.println("load at " + super.lineNum);
      instructions.add(new LoadInstruction(result, tyExtended, tyExtended, "%" + id));
      return result;
   }

   public String getID()
   {
      return id;
   }

   public String pointerOrNum(HashMap<String, String> structVarMap)
    {
      return structVarMap.get(id);
    }
}
