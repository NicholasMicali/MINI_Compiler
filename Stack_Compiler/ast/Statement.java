package ast;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public interface Statement
{
    public void typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable, Type retType);
   
    public boolean returnCheck(boolean isVoid);

    public BasicBlock controlFlow(List<BasicBlock> blocks, BasicBlock entry, BasicBlock exit, BasicBlock funcExit, LabelCounter labelC);

    public void llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs); //
}
