package ast;

import java.util.List;
//import java.util.ArrayList;
//import java.util.HashMap;

public class FunctionType
   implements Type
{
   //private final int lineNum;
   private final String name;
   public final List<Type> params;
   public final Type retType;

   public FunctionType(String name, List<Type> params, Type retType)
   {
      //this.lineNum = lineNum;
      this.name = name;
      this.params = params;
      this.retType = retType;
   }

   public String typeString()
   {
      return "function";
   }

   public String llvmType()
   {
      return "function";
   }
}
