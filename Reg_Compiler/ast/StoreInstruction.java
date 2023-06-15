package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class StoreInstruction
implements Instruction
{
   private final String ty;
   private String value;
   private final String tyP;
   private String pointer;

   public StoreInstruction(String ty, String value, String tyP, String pointer)
   {
      this.ty = ty;
      this.value = value;
      this.tyP = tyP;
      this.pointer = pointer;
   }

   public void printInst(FileWriter writer)
   {
      if (value.equals("0"))
      {
         //System.out.println(ty + " " + value + " " + pointer);
      }
      try{
         writer.write("    store " + ty + " " + value + ", " + tyP + "* " + pointer + "\n");
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
      if (pointer.equals(phiReg))
      {
        pointer = newReg;
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
      return (value.equals(reg) || pointer.equals(reg));
   }


   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }
}
