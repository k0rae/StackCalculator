package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.DivideInstruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public class DivideCreator implements InstructionCreator {

    @Override
    public Instruction create(Program program, List<String> args) {
        return new DivideInstruction(program, args);
    }
}
