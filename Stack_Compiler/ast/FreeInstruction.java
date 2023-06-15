package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class FreeInstruction
implements Instruction
{
   private final String value;

   public FreeInstruction(String value)
   {
      this.value = value;
   }

   public void printInst(FileWriter writer)
   {
    try{
        writer.write("    call void @free(i8* " + value + ")\n");
     } catch (IOException e) {
        e.printStackTrace();
     }
   }
}
