package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class BranchInstruction
implements Instruction
{
   private final String dest;

   public BranchInstruction(String dest)
   {
      this.dest = dest;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    br label %" + dest + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String getValue()
   {
      return this.dest;
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