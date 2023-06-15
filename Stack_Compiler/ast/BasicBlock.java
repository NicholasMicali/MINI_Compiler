package ast;

import java.util.List;

import ast.ReturnVInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class BasicBlock {

    public final String label;
    public List<BasicBlock> prev;
    public BasicBlock nextL;
    public BasicBlock nextR;
    public List<Statement> lines;
    public List<Declaration> params;
    public List<Declaration> decs;
    public Expression guard;
    public Boolean cycle;



   public BasicBlock(String label, List<BasicBlock> prev, BasicBlock nextL, List<Statement> lines)
   {
      this.label = label;
      if (prev == null)
      {
        this.prev = new ArrayList<BasicBlock>();
      }
      else 
      {
        this.prev = prev;
      }
      this.nextL = nextL;
      this.nextR = null;
      if (lines == null)
      {
        this.lines = new ArrayList<Statement>();
      }
      else 
      {
        this.lines = lines;
      }
      this.params = null;
      this.decs = null;
      this.guard = null;
      this.cycle = false;

   }
   public BasicBlock(String label, List<BasicBlock> prev, BasicBlock nextL, BasicBlock nextR, List<Statement> lines)
   {
      this.label = label;
      if (prev == null)
      {
        this.prev = new ArrayList<BasicBlock>();
      }
      else 
      {
        this.prev = prev;
      }
      this.nextL = nextL;
      this.nextR = nextR;
      if (lines == null)
      {
        this.lines = new ArrayList<Statement>();
      }
      else 
      {
        this.lines = lines;
      }
      this.params = null;
      this.decs = null;
      this.guard = null;
      this.cycle = false;
   }


   public void printBlock(FileWriter writer)
   {
      try {
        writer.write("    " + label + "\n");
        writer.write("        Prev: [");
        int i = 0;
        for (BasicBlock p : prev){
            writer.write(p.label);
            i ++;
            if (i < prev.size())
            {
                writer.write(", ");
            }
        }
        writer.write("]\n");
        if (nextL == null)
        {
            writer.write("        null\n");
        }
        else if (nextR == null)
        {
            if (cycle)
            {
             writer.write("        left: " + label + ", right: " + nextL.label + "\n");
            }
            else
            {
              writer.write("        next: " + nextL.label + "\n");
            }
        }
        else {
            writer.write("        left: " + nextL.label + ", right: " + nextR.label + "\n\n");
        }
        //System.out.println();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> pNames, String retType, List<String> globs)
   {
        if (label.equals("exit"))
        {
        // instructions.add(new ReturnVInstruction());
          return;
        }
        instructions.add(new LabelInstruction(label));
        if (this.params != null)
        {
            for (Declaration p : params)
            {
                pNames.add(p.name);
                p.llvmP(instructions, counter);
                p.mapstructs(structVarMap);
            }
        }
        if (this.decs != null)
        {
            for (Declaration dec : decs)
            {
                dec.llvm(instructions, counter);
                dec.mapstructs(structVarMap);
            }
        }
        for (Statement line : lines)
        {
            if ((line.getClass().equals(ReturnStatement.class)) || (line.getClass().equals(ReturnEmptyStatement.class)))
            {
                if (line.getClass().equals(ReturnStatement.class)){
                  ReturnStatement rline = (ReturnStatement)line;
                  rline.llvmRET(instructions, counter, pNames, structList, structVarMap, retType, globs);
                }
                else {
                  line.llvm(instructions, counter, pNames, structList, structVarMap, globs);
                }
                return;
            }
            line.llvm(instructions, counter, pNames, structList, structVarMap, globs);
        }
        if (guard != null)
        {
            String tResult;
            String cond = guard.llvm(instructions, counter, pNames, structList, structVarMap, globs);
            tResult = counter.newReg();
            instructions.add(new BitInstruction(tResult, "trunc", "i64", cond, "i1"));
            instructions.add(new BranchOnInstruction(tResult, nextL.label, nextR.label));
            return;
        }
        if (nextL != null)
        {
            if (!(nextL.label.equals("exit")))
            {
              instructions.add(new BranchInstruction(nextL.label));
            }
            else {
              if (retType.equals("void"))
              {
                  instructions.add(new ReturnVInstruction());
              }
              else {
                  if (retType.equals("i64")){
                    instructions.add(new ReturnInstruction(retType, "0"));
                  }
                  else {
                    instructions.add(new ReturnInstruction(retType, "null"));
                  }
              }
            }
        }
        return;
   }
}
