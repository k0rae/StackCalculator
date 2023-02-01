package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions;

public class InstructionException extends Exception {

    public InstructionException(String instructionName, String errorMessage) {
        super("For instruction " + instructionName + ": " + errorMessage);
    }
}
