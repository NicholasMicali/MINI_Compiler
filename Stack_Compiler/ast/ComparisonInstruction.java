package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ComparisonInstruction
implements Instruction
{
   private final String result;
   private final String Cond;
   private final String ty;
   private final String op1;
   private final String op2;

   public ComparisonInstruction(String result, String Cond, String ty, String op1, String op2)
   {
      this.result = result;
      this.Cond = Cond;
      this.ty = ty;
      this.op1 = op1;
      this.op2 = op2;
   }

   public void printInst(FileWriter writer)
   {
      //%r1 = icmp sle i64 %r0, 0
      try{
         writer.write("    " + result + " = icmp " + Cond + " " + ty + " " + op1 + ", " + op2 + "\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
