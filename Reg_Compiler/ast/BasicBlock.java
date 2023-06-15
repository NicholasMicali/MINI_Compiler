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
    public HashMap<String, VT> varMap;
    public Boolean sealed;



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
      this.varMap = new HashMap<String, VT>();
      this.sealed = false;
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
      this.varMap = new HashMap<String, VT>();
      this.sealed= false;
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

  public void maplocals(List<Instruction> instructions, RegisterC counter, HashMap<String, VT> varMap)
  {
    for (Declaration dec : decs)
    {
      dec.llvm(instructions, counter, varMap);
    }
  }

  public void mapparams(List<Instruction> instructions, RegisterC counter, HashMap<String, VT> varMap)
  {
    for (Declaration dec : params)
    {
      varMap.put(dec.name, new VT("%" + dec.name, dec.type.llvmType()));
    }
  }

  public void addparams(List<Instruction> instructions, RegisterC counter, HashMap<String, VT> varMap)
  {
    for (Declaration dec : params)
    {
      varMap.put(dec.name, new VT("empty", dec.type.llvmType()));
    }
  }

   public void llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, String retType, HashMap<String, VT> varMap)
   {
        if (label.equals("exit"))
        {
        // instructions.add(new ReturnVInstruction());
          return;
        }
        instructions.add(new LabelInstruction(label));
        HashMap<String, VT> blockVarMap = new HashMap<String, VT>(varMap);
        this.varMap = blockVarMap;
        if (label.equals("LU10")){
          //System.out.println("llvm " + varMap);
        }
        
        for (Statement line : lines)
        {
            if ((line.getClass().equals(ReturnStatement.class)) || (line.getClass().equals(ReturnEmptyStatement.class)))
            {
                if (line.getClass().equals(ReturnStatement.class)){
                  ReturnStatement rline = (ReturnStatement)line;
                  rline.llvmRET(instructions, counter, structList, retType, blockVarMap, this);
                }
                else {
                  line.llvm(instructions, counter, structList, blockVarMap, this);
                }
                return;
            }
            line.llvm(instructions, counter, structList, blockVarMap, this);
        }
        if ((guard != null))
        {
            String tResult;
            VT condVT = guard.llvm(instructions, counter, structList, blockVarMap, this);
            String cond = condVT.Reg;
            
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
        //this.varMap = blockVarMap;
        return;
   }

  public VT phiRec(List<Instruction> instructions, RegisterC counter, VT var, Boolean sealedVar)
  {
    if (this.varMap == null)
    {
      System.out.println(label + " " + nextL + " " + nextR);
      return null;
    }
    VT local = this.varMap.get(var.Reg);
    if (local == null)
    {
      System.out.println(this.label + " sealed: " + sealed + " : " + this.varMap.keySet());
      System.out.println(this.nextL + " " + this.nextR +  " prev: " + this.prev);
      System.out.println(this.params + " " + this.decs);
      System.out.println(var.Reg + " never declared");
      return null;
    }
    if (local.Reg.equals("empty")){
      if (prev.size() == 0)
      {
        System.out.println(label + " " + var.Reg + " never defined");
        //System.out.println(this.varMap);
        return new VT("didn't find it", var.ty);
      }
      else if (prev.size() == 1)
      {
        VT prevResult = prev.get(0).phiRec(instructions, counter, var, sealedVar);
        this.varMap.put(var.Reg, new VT(prevResult.ty, var.ty));
        //this.sealed = false;
        return new VT(this.label, prevResult.ty);
      }
      else
      {
        VT branchVT;
        List<VT> branches = new ArrayList<VT>();
        String result = counter.newReg();
        for (BasicBlock pr : this.prev)
        {
          if (pr == null){
            return null;
          }

          if ((!cycle)){
              branchVT = pr.phiRec(instructions, counter, var, sealedVar);
              branches.add(branchVT);
          }
          else {
            if (!(sealedVar)){
              branchVT = new VT(this.label, "idk_" + pr.label);
              branches.add(branchVT);
            }
          }
        }
        int i = 0;
        Boolean insert = false;
        //Boolean inBlock = false;
        List<Instruction> insts = new ArrayList<Instruction>(instructions);
        for (Instruction inst : insts)
        {
          if (inst.getClass().equals(LabelInstruction.class))
          {
            String lb = inst.getValue();
            if (lb.equals(this.label))
            {
              //insert = true;
              instructions.add(i + 1, new PhiInstruction(result, var.Reg, var.ty, branches));
              this.varMap.put(var.Reg, new VT(result, var.ty));
            }
          }
          i++;
        }
        return new VT(this.label, result);
      }
    }
    else
    {
      return new VT(this.label, local.Reg);
    }

  }


  public void sealPhi(List<Instruction> instructions, RegisterC counter, List<BasicBlock> blocks)
  {
    List<PhiInstruction> phis = new ArrayList<PhiInstruction>();
    Boolean bl = false;
    for (Instruction inst : instructions)
    {
      if (inst.getClass().equals(LabelInstruction.class))
      {
        if (bl)
        {
          bl = false;
        }
        String lb = inst.getValue();
        if (lb.equals(this.label))
        {
          bl = true;
        }
      }
      if (bl)
      {
        if (inst.getClass().equals(PhiInstruction.class))
        {
          PhiInstruction pi = (PhiInstruction)inst;
          phis.add(pi);
        }
      }
    }
    for (PhiInstruction p : phis)
    {
      //System.out.println(phis);
      seal(instructions, counter, blocks, p);
    }
  }

  public void seal(List<Instruction> instructions, RegisterC counter, List<BasicBlock> blocks, PhiInstruction pi)
  {
    for (VT branch : pi.branches)
          {
            if ((branch.ty.length() > 4) && (branch.ty.substring(0, 3).equals("idk")))
            {
              //System.out.println(branch.ty);
              VT local;
              String prevLabel = branch.ty.substring(4, branch.ty.length());
              for (BasicBlock block : blocks)
              {
                if (block.label.equals(prevLabel))
                {
                  branch.ty = block.phiRec(instructions, counter, new VT(pi.name, pi.ty), true).ty;
                  //branch.Reg = block.varMap.get(pi.name).Reg;
                  branch.Reg = block.label;
                }
              }
            }
          }
  }
}
