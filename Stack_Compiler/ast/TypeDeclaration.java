package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class TypeDeclaration
{
   public final int lineNum;
   public final String name;
   public final List<Declaration> fields;

   public TypeDeclaration(int lineNum, String name, List<Declaration> fields)
   {
      this.lineNum = lineNum;
      this.name = name;
      this.fields = fields;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter)
   {
      List<String> fieldTypes = new ArrayList<>();
      for (Declaration dec : fields)
      {
         fieldTypes.add(dec.typeDec());
      }
      instructions.add(new StructTypeInstruction(name, fieldTypes));
      return;
   }

   public void llvmSList(HashMap<String, List<Declaration>> structList)
   {
      //List<String> fieldNames = new ArrayList<String>();
      //for (Declaration dec : fields)
      //{
      //   fieldNames.add(dec.name);
      //}
      structList.put(name, fields);
   }
   public void mapstructs(HashMap<String, String> structVarMap)
   {
      for (Declaration dec : fields)
      {
         dec.mapstructs(structVarMap);
      }
   }
}
