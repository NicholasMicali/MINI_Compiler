package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public interface Lvalue
{
    public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable);

    public String getID();

    public String llvmType(HashMap<String, String> structVarMap, HashMap<String, List<Declaration>> structList);

    public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs); //HashMap<String, List<Declaration>> structList
}
