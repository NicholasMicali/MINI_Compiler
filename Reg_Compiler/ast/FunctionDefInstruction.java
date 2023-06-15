package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class FunctionDefInstruction
implements Instruction
{
   private final String retType;
   private final String name;
   private final List<String> paramTypes;
   private final List<String> paramNames;

   public FunctionDefInstruction(String retType, String name, List<String> paramTypes, List<String> paramNames)
   {
      this.retType = retType;
      this.name = name;
      this.paramTypes = paramTypes;
      this.paramNames = paramNames;
   }

   public void printInst(FileWriter writer)
   {
      //define void @tailrecursive(i64 %num)
      try{
         writer.write("define " + retType + " " + name + "(");
         int i = 0;
         while (i < paramNames.size())
         {
            writer.write(paramTypes.get(i) + " %");
            writer.write(paramNames.get(i));
            i ++;
            if (i < paramNames.size())
            {
               writer.write(", ");
            }
         }
         writer.write(")\n");
         writer.write("{\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   public String getValue()
   {
      return this.name;
   }

   public void trivialChange(String phiReg, String newReg)
   {
      
   }

   public void paramsMap(HashMap<String, String> cVals, List<String> worklist)
   {
      for (String p : paramNames)
      {
         cVals.put("%" + p, "bottom");
         worklist.add(p);
      }
   }

   public void propEval(List<String> worklist, HashMap<String, String> cVals)
   {
      
   }

   public void propChange(List<String> worklist, HashMap<String, String> cVals, String reg)
   {

   }

   public void writeUse(HashMap<String, String> cVals)
   {

   }

   public void useless(List<Instruction> instructions, List<Instruction> marked)
   {

   }

   public Boolean uses(String reg)
   {
      return false;
   }

   public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter)
   {
      
   }

}
