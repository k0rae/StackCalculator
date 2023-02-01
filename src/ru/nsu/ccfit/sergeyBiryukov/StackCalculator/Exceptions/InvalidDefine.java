package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InstructionException;

public class InvalidDefine extends InstructionException {

    public InvalidDefine(String errorMessage) {
        super("DEFINE", errorMessage);
    }
}
