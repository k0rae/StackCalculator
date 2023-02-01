package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public class PrintInstruction implements Instruction {
    private final Program program;
    private final List<String> args;
    public PrintInstruction(Program program, List<String> args) {
        this.program = program;
        this.args = args;
    }

    @Override
    public void execute() throws InstructionException {
        if(args.size() != 0) throw new InstructionException("PRINT", "Invalid number of arguments");
        Float val = program.peekStack();
        if(val == null) {
            throw new InstructionException("PRINT", "Stack is empty!");
        }
        System.out.println(val);
    }
}
