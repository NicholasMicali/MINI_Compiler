package ast;

public class VoidType
   implements Type
{

   public VoidType()
   {
   }
   public String typeString()
   {
      return "void";
   }
   public String llvmType()
   {
      return "void";
   }
}