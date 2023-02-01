package ru.nsu.ccfit.sergeyBiryukov.StackCalculator;

import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.Exceptions.InvalidDefine;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Program {
    private final Stack<Float> stack;
    private final HashMap<String, Float> defines;
    public Program() {
        stack = new Stack<>();
        defines = new HashMap<>();
    }
    public Float popStack() throws EmptyStackException {
        return stack.pop();
    }

    public Float peekStack() throws EmptyStackException {
        return stack.peek();
    }

    public void pushStack(Float value) {
        stack.push(value);
    }

    public Float getDefine(String define) {
        return defines.get(define);
    }

    public void setDefine(String define, Float value) throws InvalidDefine {
        if(Utils.IsRestricted(define) || define.startsWith("#")) throw new InvalidDefine("Can't use " + define + " as a define!");
        try {
            Float.parseFloat(define);
            throw new InvalidDefine("Can't use " + define + " as a define!");
        } catch (NumberFormatException ignored) {}
        defines.put(define, value);
    }

}
