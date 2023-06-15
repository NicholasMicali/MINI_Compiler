package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ReturnVInstruction
implements Instruction
{
    public ReturnVInstruction()
    {

    }

    public void printInst(FileWriter writer)
    {
        try{
            writer.write("    ret void\n");
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}