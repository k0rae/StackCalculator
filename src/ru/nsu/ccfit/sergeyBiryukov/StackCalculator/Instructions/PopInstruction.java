package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.EmptyStackException;
import java.util.List;

public class PopInstruction implements Instruction {
    private final Program program;
    private final List<String> args;
    public PopInstruction(Program program, List<String> args) {
        this.program = program;
        this.args = args;
    }
    @Override
    public void execute() throws InstructionException {
        if(args.size() != 0) throw new InstructionException("POP", "Invalid number of arguments");
        try {
            program.popStack();
        } catch (EmptyStackException e) {
            InstructionException f =  new InstructionException("POP", "Stack is empty!");
            f.setStackTrace(e.getStackTrace());
            throw f;
        }
    }
}
