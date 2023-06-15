package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Declaration
{
   private final int lineNum;
   public final Type type;
   public final String name;

   public Declaration(int lineNum, Type type, String name)
   {
      this.lineNum = lineNum;
      this.type = type;
      this.name = name;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, VT> varMap)
   {
      String ty = type.llvmType();
      varMap.put(name, new VT("empty", ty));
      return;
   }

   public void llvmP(List<Instruction> instructions, RegisterC counter, HashMap<String, VT> varMap)
   {
      String ty = type.llvmType();
      varMap.put(name, new VT("%" + name, ty));
      return;
   }


   public String typeDec()
   {
      return type.llvmType();
   }
 
   public void llvmGlob(List<Instruction> instructions, RegisterC counter, HashMap<String, VT> varMap)
   {
      //List<Instruction> instructions = new ArrayList<Instruction>();
      String ty = type.llvmType();
      varMap.put(name, new VT("@" + name, ty));
      instructions.add(new GlobInstruction(name, ty, "0", "8"));
      return;
   }

   public void mapstructs(HashMap<String, VT> varMap)
   {
      
   }
}
