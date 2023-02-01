package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Program;

import java.util.List;

public interface InstructionCreator {
    Instruction create(Program program, List<String> args);
}
