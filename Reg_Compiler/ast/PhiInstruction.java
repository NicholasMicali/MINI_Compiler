package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class PhiInstruction
implements Instruction
{
   public final String result;
   public final String name;
   public final String ty;
   public List<VT> branches;

   public PhiInstruction(String result, String name, String ty, List<VT> branches)
   {
      this.result = result;
      this.name = name;
      this.ty = ty;
      this.branches = branches;
   }

   public Boolean trivial()
   {
      if (branches.size() <= 1)
      {
         return true;
      }
      String prev = branches.get(0).ty;
      for (VT br : branches)
      {
         if (!(br.ty.equals(prev)))
         {
            return false;
         }
         prev = br.ty;
      }
      return true;
   }

   public String getReg()
   {
      if (branches.size() == 0)
      {
         return "unresolved phi";
      }
      return branches.get(0).ty;
   }

   public void printInst(FileWriter writer)
   {
    try{
        writer.write("    " + result + " = phi " + ty + " ");
        int i = 0;
        for (VT branch : branches)
        {
          i++;
          if (i >= branches.size())
          {
            writer.write("[" + branch.ty + ", %" + branch.Reg + "]");
          }
          else 
          {
            writer.write("[" + branch.ty + ", %" + branch.Reg + "], ");
          }
        }
        writer.write("\n");
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
      for (VT br : branches)
      {
         if (br.ty.equals(phiReg))
         {
            br.ty = newReg;
         }
      }
   }

   public void propEval(List<String> worklist, HashMap<String, String> cVals)
   {
      String left = cVals.get(branches.get(0).ty);
      String right = cVals.get(branches.get(0).ty);
      if (left == null)
      {
         left = branches.get(0).ty;
      }
      if (right == null)
      {
         right = branches.get(0).ty;
      }
      String val =  PropogationLattice.PropLattice(left, right);
      if (val.equals("calc"))
      {
         if (left.equals(right))
            {
               val = left;
            }
            else {
               val = "bottom";
            }
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
      String left = cVals.get(branches.get(0).ty);
      String right = cVals.get(branches.get(1).ty);
      String val = cVals.get(reg);
      Boolean change = false;
      if (left == null)
      {
         left = branches.get(0).ty;
      }
      if (right == null)
      {
         right = branches.get(1).ty;
      }
      if (branches.get(0).ty.equals(reg))
      {
         left = val;
         change = true;
      }
      if (branches.get(1).ty.equals(reg))
      {
         right = val;
         change = true;
      }
      if (change)
      {
         String newVal =  PropogationLattice.PropLattice(left, right);
         if (newVal.equals("calc"))
         {
            if (left.equals(right))
            {
               newVal = left;
            }
            else {
               newVal = "bottom";
            }
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
      String left = cVals.get(branches.get(0).ty);
      String right = cVals.get(branches.get(1).ty);
      if (!(left == null) && (!(left.equals("top")) && !(left.equals("bottom"))))
      {
         branches.get(0).ty = left;
      }
      if (!(right == null) && (!(right.equals("top")) && !(right.equals("bottom"))))
      {
         branches.get(1).ty = right;
      }
   }

   public void useless(List<Instruction> instructions, List<Instruction> marked)
   {
       // not sure
   }

   public Boolean uses(String reg)
   {
      Boolean used = false;
      for (VT br : branches)
      {
         if (br.ty.equals(reg))
         {
            used = true;
         }
      }
      return used;
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}