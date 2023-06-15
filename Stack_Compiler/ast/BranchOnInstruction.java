package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class BranchOnInstruction
implements Instruction
{
   private final String cond;
   private final String trueLabel;
   private final String falseLabel;

   public BranchOnInstruction(String cond, String trueLabel, String falseLabel)
   {
      this.cond = cond;
      this.trueLabel = trueLabel;
      this.falseLabel = falseLabel;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    br i1 " + cond + ", label %" + trueLabel + ", label %" + falseLabel + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}