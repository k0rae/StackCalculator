package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.SqrtInstruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public class SqrtCreator implements InstructionCreator {

    @Override
    public Instruction create(Program program, List<String> args) {
        return new SqrtInstruction(program, args);
    }
}
