package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class LvalueId
   implements Lvalue
{
   private final int lineNum;
   public final String id;

   public LvalueId(int lineNum, String id)
   {
      this.lineNum = lineNum;
      this.id = id;
   }

   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      Type variable = localTable.get(id);
      if (variable == null)
      {
         variable = symbolTable.get(id);
         if (variable == null)
         {
            System.out.println("Error: variable " + id + " not defined");
         }
      }
      return variable.typeString();
   }

   public String getID()
   {
      return id;
   }

   public String llvmType(HashMap<String, String> structVarMap, HashMap<String, List<Declaration>> structList)
   {
      String ty = structVarMap.get(id);
      String tyExtended = "i64";
      if (ty != null)
      {
         tyExtended = "%struct." + ty + "*";
         if (ty.equals("int") || ty.equals("bool"))
         {
            tyExtended = "i64";
         }
      }
      return tyExtended;
   }

   public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {

      if (params.contains(id))
      {
         return "%P_" + id;
      }
      else if (globs.contains(id))
      {
         return "@" + id;
      }
      return "%" + id;
   }
}
