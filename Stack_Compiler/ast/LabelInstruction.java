package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class LabelInstruction
implements Instruction
{
   private final String label;

   public LabelInstruction(String label)
   {
      this.label = label;
   }

   public void printInst(FileWriter writer)
   {
      try{
         if (!(label.equals("exit")))
         {
            writer.write(label + ":\n");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}