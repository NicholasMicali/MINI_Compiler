package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ReturnInstruction
implements Instruction
{
    private final String ty;
    private final String value;

    public ReturnInstruction(String ty, String value)
    {
        this.ty = ty;
        this.value = value;
    }

    public void printInst(FileWriter writer)
    {
        try{
            writer.write("    ret " + ty + " " + value + "\n");
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}