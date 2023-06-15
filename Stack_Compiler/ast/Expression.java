package ast;

import java.util.List;
import java.util.HashMap;

public interface Expression
{
    public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable);

    public String getID();

    public String pointerOrNum(HashMap<String, String> structVarMap);

    public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs); //, HashMap<String, List<Declaration>> structList
}
