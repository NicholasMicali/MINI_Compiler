package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ComparisonInstruction
implements Instruction
{
   private final String result;
   private final String Cond;
   private final String ty;
   private String op1;
   private String op2;

   public ComparisonInstruction(String result, String Cond, String ty, String op1, String op2)
   {
      this.result = result;
      this.Cond = Cond;
      this.ty = ty;
      this.op1 = op1;
      this.op2 = op2;
   }

   public void printInst(FileWriter writer)
   {
      //%r1 = icmp sle i64 %r0, 0
      try{
         writer.write("    " + result + " = icmp " + Cond + " " + ty + " " + op1 + ", " + op2 + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String getValue()
   {
      return this.result;
   }

   public void trivialChange(String phiReg, String newReg)
   {
      if (op1.equals(phiReg))
      {
         op1 = newReg;
      }
      if (op2.equals(phiReg))
      {
         op2 = newReg;
      }
   }

   public String calc(String r1, String r2)
   {
      Boolean rb = false;
      if (Cond.equals("slt"))
      {
         rb = Integer.parseInt(r1) < Integer.parseInt(r2);
      }
      if (Cond.equals("sgt"))
      {
         rb = Integer.parseInt(r1) > Integer.parseInt(r2);
      }
      if (Cond.equals("sle"))
      {
         rb = Integer.parseInt(r1) <= Integer.parseInt(r2);
      }
      if (Cond.equals("sge"))
      {
         rb = Integer.parseInt(r1) >= Integer.parseInt(r2);
      }
      if (Cond.equals("eq"))
      {
         rb = Integer.parseInt(r1) == Integer.parseInt(r2);
      }
      if (Cond.equals("ne"))
      {
         rb = Integer.parseInt(r1) != Integer.parseInt(r2);
      }
      if (rb)
      {
         return "1";
      }
      return "0";

   }

   public void propEval(List<String> worklist, HashMap<String, String> cVals)
   {
      String left = cVals.get(op1);
      String right = cVals.get(op2);
      if (left == null)
      {
         left = op1;
      }
      if (right == null)
      {
         right = op2;
      }
      //System.out.println(cVals);
      String val = PropogationLattice.PropLattice(left, right);
      if (val.equals("calc"))
      {
         //|| right)
         val = this.calc(left, right);
      }
      cVals.put(result, val);
      if (val != "top")
      {
         worklist.add(result);
      }
   }


   public void propChange(List<String> worklist, HashMap<String, String> cVals, String reg)
   {
      String oldV = cVals.get(result);
      if (oldV.equals("bottom"))
      {
         return;
      }
      String left = cVals.get(op1);
      String right = cVals.get(op2);
      String val = cVals.get(reg);
      Boolean change = false;
      if (left == null)
      {
         left = op1;
      }
      if (right == null)
      {
         right = op2;
      }
      if (op1.equals(reg))
      {
         left = val;
         change = true;
      }
      if (op2.equals(reg))
      {
         right = val;
         change = true;
      }
      if (change)
      {
         String newVal =  PropogationLattice.PropLattice(left, right);
         if (newVal.equals("calc"))
         {
            newVal = this.calc(left, right);
         }
         if (!(newVal.equals(oldV)))
         {
            cVals.put(result, newVal);
            if ((!(newVal.equals("top"))) && !(worklist.contains(result)))
            {
               worklist.add(result);
            }
         }
      }
   }

   public void writeUse(HashMap<String, String> cVals)
   {
      String left = cVals.get(op1);
      String right = cVals.get(op2);
      if (!(left == null) && (!(left.equals("top")) && !(left.equals("bottom"))))
      {
         op1 = left;
      }
      if (!(right == null) && (!(right.equals("top")) && !(right.equals("bottom"))))
      {
         op2 = right;
      }
   }

   public void useless(List<Instruction> instructions, List<Instruction> marked)
   {
       for (Instruction i : instructions)
       {
          if (i.uses(result))
          {
            return;
          }
       }
       marked.add(this);
   }

   public Boolean uses(String reg)
   {
      return ((op1.equals(reg)) || (op2.equals(reg)));
   }

   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      for (LocalV expr : valueMap.keySet())
      {
         if (expr.left.equals(op1) && expr.right.equals(op2) && expr.op.equals(Cond))
         {
            valueMap.put(new LocalV(result), valueMap.get(expr));
            return;
         }
      }
      valueMap.put(new LocalV(result, Cond, op1, op2), valCounter.newVal());
   }

}
