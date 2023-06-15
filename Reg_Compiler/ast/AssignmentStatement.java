package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentStatement
   extends AbstractStatement
{
   private final Lvalue target;
   private final Expression source;

   public AssignmentStatement(int lineNum, Lvalue target, Expression source)
   {
      super(lineNum);
      this.target = target;
      this.source = source;
   }

   public boolean returnCheck(boolean isVoid)
   {
      return false;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      //Type assignment = source.typeCheck(typeTable, symbolTable, localTable);
      
      String variable = target.typeCheck(typeTable, symbolTable, localTable);
      String value = source.typeCheck(typeTable, symbolTable, localTable);
      
      if ((variable == "int") || (variable == "bool")){
         if (variable != value)
         {
            System.out.println("Error: Type of assingment does not match the variable at line: " + lineNum);
         }
      }
      else if (!((variable.equals(value)) || ((variable == "null") && (value != "int") && (value != "bool")) || 
                                        ((value == "null") && (variable != "int") && (variable != "bool"))))
      {
         System.out.println("Error: Type of assingment does not match the variable at line: " + lineNum);
      }
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      entry.lines.add(this);
      return entry;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      VT targetVT;
      VT sourceVT;
      String result;
      if (source.getClass().equals(ReadExpression.class)) // change later
      {
         //String Rresult = counter.newReg();
         instructions.add(new ReadInstruction("@.read_scratch"));
         result = counter.newReg();
         instructions.add(new LoadInstruction(result, "i64", "i64", "@.read_scratch"));
         sourceVT = new VT(result, "i64");
      }
      else if (source.getClass().equals(NewExpression.class)) // change later
      {
         //%u11 = call i8* @malloc(i64 24)
	      //%u12 = bitcast i8* %u11 to %struct.foo*
         String mResult = counter.newReg();
         instructions.add(new MallocInstruction(mResult, "i8*", structList.get(source.getID()).size() * 8 + ""));
         result = counter.newReg();
         instructions.add(new BitInstruction(result, "bitcast", "i8*", mResult, "%struct." + source.getID() + "*"));
         sourceVT = new VT(result, "%struct." + source.getID() + "*");
      }
      else {
         sourceVT = source.llvm(instructions, counter, structList, varMap, curr);
      }
      if (target.getClass().equals(LvalueId.class))
      {
         LvalueId Lid = (LvalueId)target;
         String globVal = varMap.get(Lid.id).Reg;
         String globTy = varMap.get(Lid.id).ty;
         if (globVal.substring(0, 1).equals("@"))
         {
            //sourceVT.ty
            instructions.add(new StoreInstruction(globTy, sourceVT.Reg, globTy, globVal));
         }
         varMap.put(Lid.id, sourceVT);
         return;
      }
      else {
         targetVT = target.llvm(instructions, counter, structList, varMap, curr);
         instructions.add(new StoreInstruction(targetVT.ty, sourceVT.Reg, targetVT.ty, targetVT.Reg));
      }
      return;
   }
}
