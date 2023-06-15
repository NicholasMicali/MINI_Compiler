package ast;

public class BoolType
   implements Type
{
   public String typeString()
   {
      return "bool";
   }
   public String llvmType()
   {
      return "i64";
   }
}
