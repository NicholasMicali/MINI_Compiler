package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class MallocInstruction
implements Instruction
{
   private final String result;
   private final String ty;
   private final String num;

   public MallocInstruction(String result, String ty, String num)
   {
      this.result = result;
      this.ty = ty;
      this.num = num;
   }

   public void printInst(FileWriter writer)
   {
    try{
        writer.write("    " + result + " = call " + ty + " @malloc(i64 " + num + ")\n");
     } catch (IOException e) {
        e.printStackTrace();
     }
   }
}
//MallocInstruction(mResult, "i64", structList.get(source.getID()).size() * 8))
