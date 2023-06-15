package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class GetEPInstruction
implements Instruction
{
   private final String result;
   private final String tyP;
   private final String ptrval;
   private final String index;

   public GetEPInstruction(String result, String tyP, String ptrval, String index)
   {
      this.result = result;
      this.tyP = tyP;
      this.ptrval = ptrval;
      this.index = index;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    " + result + " = getelementptr " + tyP + ", " + tyP + "* " + ptrval + ", i1 0, i32 " + index + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
}
