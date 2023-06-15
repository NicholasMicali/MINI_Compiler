package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ConditionalStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement thenBlock;
   private final Statement elseBlock;

   public ConditionalStatement(int lineNum, Expression guard,
      Statement thenBlock, Statement elseBlock)
   {
      super(lineNum);
      this.guard = guard;
      this.thenBlock = thenBlock;
      this.elseBlock = elseBlock;
   }

   public boolean returnCheck(boolean isVoid)
   {
      return thenBlock.returnCheck(isVoid) && elseBlock.returnCheck(isVoid);
   }

   public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType)
   {
      String guardType = guard.typeCheck(typeTable, symbolTable, localTable);
      //System.out.println(guardType);
      if (guardType != "bool")
      {
         System.out.println("Error: if gaurd is not of type bool at line: " + lineNum);
      }
      else 
      {
         thenBlock.typeCheck(typeTable, symbolTable, localTable, retType);
         elseBlock.typeCheck(typeTable, symbolTable, localTable, retType);

      }
   }

   public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC)
   {
      List<BasicBlock> prevsl = new ArrayList<BasicBlock>();
      List<BasicBlock> prevsr = new ArrayList<BasicBlock>();
      List<BasicBlock> prevse = new ArrayList<BasicBlock>();
      prevsl.add(entry);
      prevsr.add(entry);
      BasicBlock thenBasicBlock = new BasicBlock(labelC.newLabel(), prevsl, null, null);
      BasicBlock ifExit = new BasicBlock(labelC.newLabel(), prevse, null, null);

      BasicBlock elseBasicBlock;
      if (((BlockStatement)elseBlock).statements.size() == 0)
      {
         elseBasicBlock = ifExit;
      }
      else 
      {
         elseBasicBlock = new BasicBlock(labelC.newLabel(), prevsr, null, null);
      }
      entry.nextL = thenBasicBlock;
      entry.nextR = elseBasicBlock;
      //entry.prev.add(thenBasicBlock);
      entry.guard = guard;
      blocks.add(entry);
      BasicBlock texit = thenBlock.controlFlow(blocks, thenBasicBlock, ifExit, funcExit, labelC);

      if ((texit.nextL != null) && (!(texit.nextL.label.equals("exit"))))
      {
         ifExit.prev.add(thenBasicBlock);
      }
      if (!(((BlockStatement)elseBlock).statements.size() == 0))
      {
         BasicBlock eexit = elseBlock.controlFlow(blocks, elseBasicBlock, ifExit, funcExit, labelC);
         if ((eexit.nextL != null) && (!(eexit.nextL.label.equals("exit"))))
         {
            ifExit.prev.add(elseBasicBlock);
         }
      }
      else {
         ifExit.prev.add(entry);
      }
      return ifExit;
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      return;
   }
}
