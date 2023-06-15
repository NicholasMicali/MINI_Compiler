package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ReturnInstruction
implements Instruction
{
    private final String ty;
    private String value;

    public ReturnInstruction(String ty, String value)
    {
        this.ty = ty;
        this.value = value;
    }

    public void printInst(FileWriter writer)
    {
        try{
            writer.write("    ret " + ty + " " + value + "\n");
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
      String left = cVals.get(value);
      if (!(left == null) && (!(left.equals("top")) && !(left.equals("bottom"))))
      {
        value = left;
      }
   }

   public void useless(List<Instruction> instructions, List<Instruction> marked)
   {

   }

   public Boolean uses(String reg)
   {
      return value.equals(reg);
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}