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

   public void llvm(List<Instruction> instructions, RegisterC counter)
   {
      //List<Instruction> instructions = new ArrayList<Instruction>();
      String ty = type.llvmType();
      instructions.add(new AllocaInstruction("%" + name, ty));
      return;
   }

   public void llvmP(List<Instruction> instructions, RegisterC counter)
   {
      //List<Instruction> instructions = new ArrayList<Instruction>();
      String ty = type.llvmType();
      instructions.add(new AllocaInstruction("%P_" + name, ty));
      //store i64 %num, i64* %_P_num
      instructions.add(new StoreInstruction(ty, "%" + name, ty, "%P_" + name));
      return;
   }


   public String typeDec()
   {
      return type.llvmType();
   }
 
   public void llvmGlob(List<Instruction> instructions, RegisterC counter, List<String> globs)
   {
      //List<Instruction> instructions = new ArrayList<Instruction>();
      String ty = type.llvmType();
      globs.add(name);
      instructions.add(new GlobInstruction(name, ty, "0", "8"));
      return;
   }

   public void mapstructs(HashMap<String, String> structVarMap)
   {
      String ty = type.typeString();
      if (((!(ty.equals("int"))) && (!(ty.equals("bool")))) || (structVarMap.get(name) != null))
      {
         if (structVarMap.get(name) != null)
         {
            structVarMap.put("L_" + name, ty);
         }
         structVarMap.put(name, ty);
      }
   }
}
