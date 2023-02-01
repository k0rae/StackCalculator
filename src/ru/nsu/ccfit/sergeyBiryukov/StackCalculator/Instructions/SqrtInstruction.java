package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.EmptyStackException;
import java.util.List;

public class SqrtInstruction implements Instruction {
    private final Program program;
    private final List<String> args;
    public SqrtInstruction(Program program, List<String> args) {
        this.program = program;
        this.args = args;
    }
    @Override
    public void execute() throws InstructionException {
        if(args.size() != 0) throw new InstructionException("SQRT", "Invalid number of arguments");
        try {
            Float f = program.popStack();
            program.pushStack((float) Math.sqrt(f));
        } catch (EmptyStackException e) {
            throw new InstructionException("SQRT", "Stack is empty!");
        }
    }
}
