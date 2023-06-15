package ast;

import java.util.List;
import java.util.HashMap;

public interface Expression
{
    public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable);

    public String getID();

    public String pointerOrNum(HashMap<String, String> structVarMap);

    public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr); //, HashMap<String, List<Declaration>> structList
}
