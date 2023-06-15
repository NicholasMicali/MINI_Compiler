package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class MallocInstruction
implements Instruction
{
   private final String result;
   private final String ty;
   private final String num;

   public MallocInstruction(String result, String ty, String num)
   {
      this.result = result;
      this.ty = ty;
      this.num = num;
   }

   public void printInst(FileWriter writer)
   {
    try{
        writer.write("    " + result + " = call " + ty + " @malloc(i64 " + num + ")\n");
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
      return false;
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}
