package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class BranchOnInstruction
implements Instruction
{
   private String cond;
   private final String trueLabel;
   private final String falseLabel;

   public BranchOnInstruction(String cond, String trueLabel, String falseLabel)
   {
      this.cond = cond;
      this.trueLabel = trueLabel;
      this.falseLabel = falseLabel;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    br i1 " + cond + ", label %" + trueLabel + ", label %" + falseLabel + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String getValue()
   {
      return this.cond;
   }

   public void trivialChange(String phiReg, String newReg)
   {
      if (cond.equals(phiReg))
      {
         cond = newReg;
      }
   }

   public void propEval(List<String> worklist, HashMap<String, String> cVals)
   {
      
   }

   public void propChange(List<String> worklist, HashMap<String, String> cVals, String reg)
   {
      
   }

   public void useless(List<Instruction> instructions, List<Instruction> marked)
   {
      
   }

   public void writeUse(HashMap<String, String> cVals)
   {
      String left = cVals.get(cond);
      if (!(left == null) && (!(left.equals("top")) && !(left.equals("bottom"))))
      {
         cond = left;
      }
   }

   public Boolean uses(String reg)
   {
      return (cond.equals(reg));
   }

   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }


}