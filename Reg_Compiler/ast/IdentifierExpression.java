package ast;

import java.util.List;
import java.util.ArrayList;
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

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      String result;
      //String ty = structVarMap.get(id);
      VT valType = varMap.get(id);
      if (valType == null)
      {
         System.out.println(id + " not in map at " + lineNum);
         System.out.println(varMap);
         //result = counter.newReg();
         return new VT(id, "idk");
      }
      if (valType.Reg.equals("empty"))
      {
         //System.out.print(id + " not in current block");
         curr.sealed = false;
         //System.out.println(id + " at line: " + super.lineNum);
         VT prevVal = curr.phiRec(instructions, counter, new VT(id, valType.ty), false); 
         return new VT(prevVal.ty, valType.ty);
      }
      if (valType.Reg.substring(0, 1).equals("@"))
      {
         result = counter.newReg();
         instructions.add(new LoadInstruction(result, valType.ty, valType.ty, valType.Reg));
         return new VT(result, valType.ty);
      }
      return valType;
      
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
