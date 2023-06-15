package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class InvocationInstruction
implements Instruction
{
   private final String result;
   private final String ty;
   private final String fnval;
   private final List<String> args;
   private final List<Declaration> argTypes;

   public InvocationInstruction(String result, String ty, String fnval, List<String> args, List<Declaration> argTypes)
   {
      this.result = result;
      this.ty = ty;
      this.fnval = fnval;
      this.args = args;
      this.argTypes = argTypes;
   }

   public void printInst(FileWriter writer)
   {
      try{
         writer.write("    " + result + " = call " + ty + " @" + fnval + "(");
         int i = 0;
         for (String a : args)
         {
            writer.write(argTypes.get(i).typeDec() + " ");
            writer.write(a);
            i++;
            if (i < args.size())
            {
               writer.write(", ");
            }
         }
         writer.write(")\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
}