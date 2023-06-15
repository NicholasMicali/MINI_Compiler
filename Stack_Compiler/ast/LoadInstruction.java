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
   private final String pointer;

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
}