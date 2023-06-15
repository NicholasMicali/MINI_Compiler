package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.lang.Class;

public class LvalueDot
   implements Lvalue
{
   private final int lineNum;
   private final Expression left;
   private final String id;

   public LvalueDot(int lineNum, Expression left, String id)
   {
      this.lineNum = lineNum;
      this.left = left;
      this.id = id;
   }

   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      
      String leftId = left.typeCheck(typeTable, symbolTable, localTable);
      if (typeTable.get(leftId) == null)
      {
         System.out.println("Error: invalid dot expression at line: " + lineNum);
         return leftId;
      }
      else {
         Type idType = typeTable.get(leftId).get(id);
         if (idType == null)
         {
            System.out.println("Error: invalid dot expression at line: " + lineNum);
            return "null";
         }
         else {
            return idType.typeString();
         }
      }

   }

   public String getID()
   {
      return id;
   }

   public String llvmType(HashMap<String, VT> varMap, HashMap<String, List<Declaration>> structList)
   {
     return "na";
   }

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {

      VT leftStruct = left.llvm(instructions, counter, structList, varMap, curr);
      String ty = leftStruct.ty.substring(8, leftStruct.ty.length() -1);
      List<Declaration> struct = structList.get(ty);
      int i = 0;
      int index = 0;
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
      String result = counter.newReg();
      instructions.add(new GetEPInstruction(result, leftStruct.ty.substring(0, leftStruct.ty.length() -1), leftStruct.Reg, index + ""));
      return new VT(result, lty);
   }
}
