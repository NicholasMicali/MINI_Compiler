package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

public class PrintInstruction
implements Instruction
{
    private final String value;
    private final Boolean ln;

    public PrintInstruction(String value, Boolean ln)
    {
        this.value = value;
        this.ln = ln;
    }

    public void printInst(FileWriter writer)
    {
        try{
            if (ln)
            {
                writer.write("    call i64 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.println, i32 0, i32 0), i64 " + value + ")\n");
            }
            else
            {
                writer.write("    call i64 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.print, i32 0, i32 0), i64 " + value + ")\n");
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}
