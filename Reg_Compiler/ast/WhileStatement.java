package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class WhileStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement body;

   public WhileStatement(int lineNum, Expression guard, Statement body)
   {
      super(lineNum);
      this.guard = guard;
      this.body = body;
   }

   public boolean returnCheck(boolean isVoid)
   {
      return false;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      String guardType = guard.typeCheck(typeTable, symbolTable, localTable);
      if (guardType != "bool")
      {
         System.out.println("Error: if gaurd is not of type bool at line: " + lineNum);
      }
      else 
      {
         body.typeCheck(typeTable, symbolTable, localTable, retType);
      }
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      BasicBlock whileBlock = new BasicBlock(labelC.newLabel(), null, null, null);
      BasicBlock whileExit = new BasicBlock(labelC.newLabel(), null, null, null);
      whileBlock.prev.add(entry);
      whileBlock.guard = guard;
      whileBlock.cycle = true;
      entry.nextL = whileBlock;
      entry.nextR = whileExit;
      entry.guard = guard;
      blocks.add(entry);
      whileExit.prev.add(entry);
      BlockStatement blockbody = (BlockStatement)body;
      entry = blockbody.whileControlFlow(blocks, whileBlock, whileExit, funcExit, labelC, whileBlock, guard);
      return whileExit;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      return;
   }
}
