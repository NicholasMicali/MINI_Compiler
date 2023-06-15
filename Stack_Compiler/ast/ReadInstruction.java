package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class ReadInstruction
implements Instruction
{
    private final String value;

    public ReadInstruction(String value)
    {
        this.value = value;
    }

    public void printInst(FileWriter writer)
    {
        try{
            writer.write("    call i64 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.read, i32 0, i32 0), i64* " + value + ")\n");
         } catch (IOException e) {
            e.printStackTrace();
         }
        
    }
}