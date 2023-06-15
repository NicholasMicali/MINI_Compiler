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
   private final String value;
   private final String tyP;
   private final String pointer;

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
}
