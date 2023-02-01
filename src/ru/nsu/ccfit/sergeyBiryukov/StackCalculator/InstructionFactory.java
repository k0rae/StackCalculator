package ru.nsu.ccfit.sergeyBiryukov.StackCalculator;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Creators.InstructionCreator;
import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Instructions.Instruction;

import java.util.HashMap;
import java.util.List;

public class InstructionFactory {
    private static final HashMap<String, InstructionCreator> creatorMap = new HashMap<>();
    public static void RegisterCreator(String name, InstructionCreator creator) {
        creatorMap.put(name, creator);
    }
    public static Instruction CreateInstruction(String name, Program program, List<String> args) {
        return creatorMap.get(name).create(program, args);
    }
}
