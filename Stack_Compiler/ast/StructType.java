package ast;

public class StructType
   implements Type
{
   private final int lineNum;
   public final String name;

   public StructType(int lineNum, String name)
   {
      this.lineNum = lineNum;
      this.name = name;
   }

   public String typeString()
   {
      return name;
   }

   public String llvmType()
   {
      return "%struct." + name + "*";
   }

}
