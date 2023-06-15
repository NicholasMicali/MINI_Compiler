package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class GetEPInstruction
implements Instruction
{
   private final String result;
   private final String tyP;
   private String ptrval;
   private final String index;

   public GetEPInstruction(String result, String tyP, String ptrval, String index)
   {
      this.result = result;
      this.tyP = tyP;
      this.ptrval = ptrval;
      this.index = index;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    " + result + " = getelementptr " + tyP + ", " + tyP + "* " + ptrval + ", i1 0, i32 " + index + "\n");
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
      if (ptrval.equals(phiReg))
      {
         ptrval = newReg;
      }
   }

   public void propEval(List<String> worklist, HashMap<String, String> cVals)
   {
      cVals.put(result, "bottom");
      worklist.add(result);
   }

   public void propChange(List<String> worklist, HashMap<String, String> cVals, String reg)
   {

   }

   public void writeUse(HashMap<String, String> cVals)
   {

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
      return ptrval.equals(reg);
   }

   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }

}
