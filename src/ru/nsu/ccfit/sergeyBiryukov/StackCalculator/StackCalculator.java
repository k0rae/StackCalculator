package ru.nsu.ccfit.sergeyBiryukov.StackCalculator;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators.*;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.LineException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;

import java.io.File;
import java.io.IOException;
import java.util.*;

enum ReadMode {
    COMMAND_LINE,
    FILE
}
public class StackCalculator {
    private final String fileName;
    private final Program program;
    private final ReadMode mode;
    public StackCalculator(String fileName) {
        this.fileName = fileName;
        this.mode = ReadMode.FILE;
        this.program = new Program();
    }
    public StackCalculator() {
        this.fileName = "";
        this.mode = ReadMode.COMMAND_LINE;
        this.program = new Program();
    }

    private void RegisterInstructions() {
        InstructionFactory.RegisterCreator("DEFINE", new DefineCreator());
        InstructionFactory.RegisterCreator("PUSH", new PushCreator());
        InstructionFactory.RegisterCreator("PRINT", new PrintCreator());
        InstructionFactory.RegisterCreator("POP", new PopCreator());
        InstructionFactory.RegisterCreator("SQRT", new SqrtCreator());
        InstructionFactory.RegisterCreator("ADD", new AddCreator());
        InstructionFactory.RegisterCreator("SUB", new SubtractCreator());
        InstructionFactory.RegisterCreator("MUL", new MultiplyCreator());
        InstructionFactory.RegisterCreator("DIV", new DivideCreator());
    }
    public void Run() throws Exception {
        RegisterInstructions();
        Scanner scanner = null;
        if(this.mode == ReadMode.COMMAND_LINE) {
            scanner = new Scanner(System.in);
        } else if (this.mode == ReadMode.FILE) {
            scanner = new Scanner(new File(fileName));
        }
        int lineNumber = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNumber++;
            if(line.startsWith("#")) continue;
            Scanner lineScanner = new Scanner(line);
            if(lineScanner.hasNext()) {
                String instructionString = lineScanner.next();
                List<String> args = new ArrayList<>();
                while(lineScanner.hasNext()) {
                    String next = lineScanner.next();
                    args.add(next);
                }
                try {
                    Instruction instruction = InstructionFactory.CreateInstruction(instructionString, program, args);
                    instruction.execute();
                } catch (InstructionException e) {
                    e.addSuppressed(new LineException(lineNumber));
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    Exception f = new Exception("No such instruction " + instructionString);
                    f.setStackTrace(e.getStackTrace());
                    throw f;
                }
            }
        }
    }

}
