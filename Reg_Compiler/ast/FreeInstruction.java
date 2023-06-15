package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class FreeInstruction
implements Instruction
{
   private String value;

   public FreeInstruction(String value)
   {
      this.value = value;
   }

   public void printInst(FileWriter writer)
   {
    try{
        writer.write("    call void @free(i8* " + value + ")\n");
     } catch (IOException e) {
        e.printStackTrace();
     }
   }

   public String getValue()
   {
      return this.value;
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
      
   }

   public void propChange(List<String> worklist, HashMap<String, String> cVals, String reg)
   {

   }

   public void writeUse(HashMap<String, String> cVals)
   {

   }

   public void useless(List<Instruction> instructions, List<Instruction> marked)
   {

   }

   public Boolean uses(String reg)
   {
      return (value.equals(reg));
   }

   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }

}
