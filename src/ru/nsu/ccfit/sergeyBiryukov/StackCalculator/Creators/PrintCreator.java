package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.PrintInstruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public class PrintCreator implements InstructionCreator {
    @Override
    public Instruction create(Program program, List<String> args) {
        return new PrintInstruction(program, args);
    }
}
