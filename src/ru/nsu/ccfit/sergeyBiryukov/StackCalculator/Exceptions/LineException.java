package ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions;

public class LineException extends Exception {
    public LineException(int line) {
        super("Error at line " + line);
    }
}
