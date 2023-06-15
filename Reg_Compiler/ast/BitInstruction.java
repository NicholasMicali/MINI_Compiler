package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class BitInstruction
implements Instruction
{
   private final String result;
   private final String Inst;
   private final String ty;
   public String value;
   private final String ty2;

   public BitInstruction(String result, String Inst, String ty, String value, String ty2)
   {
      this.result = result;
      this.Inst = Inst;
      this.ty = ty;
      this.value = value;
      this.ty2 = ty2;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    " + result + " = " + Inst + " " + ty + " " + value + " to " + ty2 + "\n");
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
      if (value.equals(phiReg))
      {
         value = newReg;
      }
   }

   public void propEval(List<String> worklist, HashMap<String, String> cVals)
   {
      String left = cVals.get(value);
      if (left == null)
      {
         left = value;
      }
      String val =  PropogationLattice.PropLattice(left, "top");
      if (val.equals("calc"))
      {
         val = value;
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
      String val = cVals.get(value);
      String c = cVals.get(reg);
      Boolean change = false;
      if (val == null)
      {
         val = value;
      }
      if (value.equals(reg))
      {
         val = c;
         String newVal =  PropogationLattice.PropLattice(val, "top");
         if (newVal.equals("calc"))
         {
            newVal = value;
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
      String left = cVals.get(value);
      if (!(left == null) && (!(left.equals("top")) && !(left.equals("bottom"))))
      {
         value = left;
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
      return value.equals(reg);
   }

   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }

}