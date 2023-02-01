package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Utils;

import java.util.List;

public class PushInstruction implements Instruction {
    private final Program program;
    private final List<String> args;
    public PushInstruction(Program program, List<String> args) {
        this.program = program;
        this.args = args;
    }
    @Override
    public void execute() throws InstructionException {
        if(args.size() != 1) throw new InstructionException("PUSH", "Invalid number of arguments");
        String valueStr = args.get(0);
        Float f = Utils.ParseDefines(program, args).get(0);
        if(f == null) {
            throw new InstructionException("PUSH", "Invalid argument");
        }
        program.pushStack(f);
    }
}
