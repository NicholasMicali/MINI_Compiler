package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class LoadInstruction
implements Instruction
{
   private final String result;
   public final String ty;
   private final String tyP;
   private String pointer;

   public LoadInstruction(String result, String ty, String tyP, String pointer)
   {
      this.result = result;
      this.ty = ty;
      this.tyP = tyP;
      this.pointer = pointer;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    " + result + " = load " + ty + ", " + tyP + "* " + pointer + "\n");
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
      if (pointer.equals(phiReg))
      {
         pointer = newReg;
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
      return pointer.equals(reg);
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}