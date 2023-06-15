package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ReadInstruction
implements Instruction
{
    private String value;

    public ReadInstruction(String value)
    {
        this.value = value;
    }

    public void printInst(FileWriter writer)
    {
        try{
            writer.write("    call i64 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.read, i32 0, i32 0), i64* " + value + ")\n");
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
      cVals.put(value, "bottom");
      worklist.add(value);
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
          if (i.uses(value))
          {
            return;
          }
       }
       marked.add(this);
   }

   public Boolean uses(String reg)
   {
      return false;
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}