package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BlockStatement
   extends AbstractStatement
{
   public final List<Statement> statements;

   public BlockStatement(int lineNum, List<Statement> statements)
   {
      super(lineNum);
      this.statements = statements;
   }

   public static BlockStatement emptyBlock()
   {
      return new BlockStatement(-1, new ArrayList<>());
   }

   public boolean returnCheck(boolean isVoid)
   {
      if (isVoid) {
         return true;
      }
      if (statements.size() == 0)
      {
         return false;
      }
      for (Statement state : statements)
      {
         //System.out.println(lineNum);
         if (state.returnCheck(isVoid))
         {
            return true;
         }
      }

      //System.out.println("Error: block does not contain a return statement, block starts at line: " + lineNum);
      return false;
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      //System.out.println(retType);
      for (Statement state : statements)
      {
         state.typeCheck(typeTable, symbolTable, localTable, retType);
      }
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      for (Statement state : statements)
      {
         entry = state.controlFlow(blocks, entry, exit, funcExit, labelC);
         if (entry == null)
         {
            System.out.println(state);
         }
         if (entry.label == "exit")
         {
            return exit;
         }
      }
      entry.nextL = exit;
      exit.prev.add(entry); 
      blocks.add(entry);
      return exit;
   }

   public BasicBlock whileControlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC, BasicBlock loop, Expression guard)
   {
      for (Statement state : statements)
      {
         entry = state.controlFlow(blocks, entry, exit, funcExit, labelC);
         if (entry == null)
         {
            System.out.println(state);
         }
         if (entry.label == "exit")
         {
            return exit;
         }
      }
      entry.nextL = loop;
      entry.nextR = exit;
      entry.guard = guard;
      exit.prev.add(entry);
      loop.prev.add(entry);
      blocks.add(entry);
      return exit;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      return;
   }

}
