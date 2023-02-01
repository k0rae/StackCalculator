package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.AddInstruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public class AddCreator implements InstructionCreator {
    @Override
    public Instruction create(Program program, List<String> args) {
        return new AddInstruction(program, args);
    }
}
