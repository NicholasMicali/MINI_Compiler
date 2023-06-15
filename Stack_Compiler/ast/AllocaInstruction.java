package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class AllocaInstruction
implements Instruction
{
    private final String result;
    private final String ty;

    public AllocaInstruction(String result, String ty)
    {
        this.result = result;
        this.ty = ty;
    }

    public void printInst(FileWriter writer)
    {
        try{
            writer.write("    " + result + " = alloca " + ty + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}