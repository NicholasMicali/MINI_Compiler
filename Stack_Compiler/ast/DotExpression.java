package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.lang.Class;

public class DotExpression
   extends AbstractExpression
{
   private final Expression left;
   private final String id;

   public DotExpression(int lineNum, Expression left, String id)
   {
      super(lineNum);
      this.left = left;
      this.id = id;
   }


   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      String leftId = left.typeCheck(typeTable, symbolTable, localTable);
      if (typeTable.get(leftId) == null)
      {
         System.out.println("Error: invalid dot expression at line: " + super.lineNum);
         return leftId;
      }
      else {
         Type idType = typeTable.get(leftId).get(id);
         if (idType == null)
         {
            System.out.println("Error: invalid dot expression at line: " + super.lineNum);
            return "null";
         }
         else {
            return idType.typeString();
         }
      }
   }

   public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      String leftStruct = left.llvm(instructions, counter, params, structList, structVarMap, globs);
      String result = counter.newReg();
      List<Declaration> struct = structList.get(structVarMap.get(left.getID()));
      int i = 0;
      int index = 0;
      String ty = structVarMap.get(left.getID());
      String lty = "i64";
      for (Declaration s : struct)
      {
         if (s.name.equals(id))
         {
            index = i;
            lty = s.type.llvmType();
         }
         i++;
      }
      String tyExtended = "i64";
      if (ty != null)
      {
         tyExtended = "%struct." + ty;// + "*";
      }
      instructions.add(new GetEPInstruction(result, tyExtended, leftStruct, index + ""));
      String resultL = counter.newReg();
      instructions.add(new LoadInstruction(resultL, lty, lty, result));
      return resultL;
   }

   public String getID()
   {
      return id;
   }

   public String pointerOrNum(HashMap<String, String> structVarMap)
   {
      String val = structVarMap.get(id);
      return val;
   }
}
