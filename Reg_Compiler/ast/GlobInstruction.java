package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class GlobInstruction
implements Instruction
{
   private final String name;
   private final String ty;
   private final String something;
   private final String align;

   public GlobInstruction(String name, String ty, String something, String align)
   {
      this.name = name;
      this.ty = ty;
      this.something = something;
      this.align = align;
   }

   public void printInst(FileWriter writer)
   {
      //@globalfoo = common global %struct.foo* null, align 4
      try{
         if (ty.equals("i64"))
         {
            writer.write("@" + name + " = common global i64 0\n");
            //      "@" + 
         }
         else {
            writer.write("@" + name + " = common global " + ty + " null, align 4\n");
         }
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