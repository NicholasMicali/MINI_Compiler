package ast;

public class IntType
   implements Type
{
   public String typeString()
   {
      return "int";
   }

   public String llvmType()
   {
      return "i64";
   }
}
