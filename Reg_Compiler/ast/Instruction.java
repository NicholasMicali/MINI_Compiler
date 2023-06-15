package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;

public interface Instruction
{
    public void printInst(FileWriter writer);

    public String getValue();

    public void trivialChange(String phiReg, String newReg);

    public void propEval(List<String> worklist, HashMap<String, String> cVals);

    public void propChange(List<String> worklist, HashMap<String, String> cVals, String reg);

    public void writeUse(HashMap<String, String> cVals);

    public void useless(List<Instruction> instructions, List<Instruction> marked);

    public Boolean uses(String reg);

    public void lvMap(HashMap<LocalV, String> valueMap, RegisterC valCounter);

}