package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InvalidDefine;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public class DefineInstruction implements Instruction {
    private final Program program;
    private final List<String> args;
    public DefineInstruction(Program program, List<String> args) {
        this.program = program;
        this.args = args;
    }
    @Override
    public void execute() throws InstructionException {
        if(args.size() != 2) throw new InstructionException("DEFINE", "Invalid number of arguments");
        program.setDefine(args.get(0), Float.parseFloat(args.get(1)));
    }
}
