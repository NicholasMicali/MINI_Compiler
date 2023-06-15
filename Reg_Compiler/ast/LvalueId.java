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

   public String llvmType(HashMap<String, VT> varMap, HashMap<String, List<Declaration>> structList)
   {
      VT valType = varMap.get(id);
      if (valType != null)
      {
         return valType.ty;
      }
      return "lvalId lame";
   }

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      
     VT valType = varMap.get(id);
     String result;
     if (valType != null)
     {
       if (valType.Reg == null)
       {
         VT prevVal = curr.phiRec(instructions, counter, valType, false);
         return new VT(prevVal.ty, valType.ty);
       }
       else {
         return valType;
       }
     }
     else
     {
      System.out.println(id + " not in map at " + lineNum);
     }
     return null;
   }
}
