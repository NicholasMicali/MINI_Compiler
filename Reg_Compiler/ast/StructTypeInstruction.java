package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class StructTypeInstruction
implements Instruction
{
   private final String name;
   private final List<String> fields;

   public StructTypeInstruction(String name, List<String> fields)
   {
      this.name = name;
      this.fields = fields;
   }

   public void printInst(FileWriter writer)
   {
      //%struct.simple = type {i64}
      try{
         writer.write("%struct." + name + " = type {");
         int i = 0;
         for (String f : fields)
         {
            writer.write(f);
            i ++;
            if (i < fields.size())
            {
               writer.write(", ");
            }
         }
         writer.write("}\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String getValue()
   {
      return this.name;
   }

   public void trivialChange(String phiReg, String newReg)
   {
      
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
      return false;
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}
