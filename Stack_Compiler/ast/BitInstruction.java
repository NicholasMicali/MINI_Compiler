package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class BitInstruction
implements Instruction
{
   private final String result;
   private final String Inst;
   private final String ty;
   private final String value;
   private final String ty2;

   public BitInstruction(String result, String Inst, String ty, String value, String ty2)
   {
      this.result = result;
      this.Inst = Inst;
      this.ty = ty;
      this.value = value;
      this.ty2 = ty2;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    " + result + " = " + Inst + " " + ty + " " + value + " to " + ty2 + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}