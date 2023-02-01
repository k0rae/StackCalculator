package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.EmptyStackException;
import java.util.List;

public class DivideInstruction implements Instruction {
    private final Program program;
    private final List<String> args;
    public DivideInstruction(Program program, List<String> args) {
        this.program = program;
        this.args = args;
    }
    @Override
    public void execute() throws InstructionException {
        if(args.size() != 0) throw new InstructionException("DIV", "Invalid number of arguments");
        try {
            Float f1 = program.popStack();
            Float f2 = program.popStack();
            program.pushStack(f1/f2);
        } catch (EmptyStackException e) {
            throw new InstructionException("DIV", "Stack is empty/has not enough elements!");
        }
    }
}
