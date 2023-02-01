package ru.nsu.ccfit.sergeyBiryukov.StackCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final List<String> restricted = Arrays.asList("DEFINE", "POP", "PUSH", "SQRT", "+", "-", "*", "/", "PRINT");
    public static boolean IsRestricted(String word) {
        return restricted.contains(word);
    }
    public static List<Float> ParseDefines(Program program, List<String> args) {
        List<Float> result = new ArrayList<>();
        for(String arg : args) {
            try {
                Float f = Float.parseFloat(arg);
                result.add(f);
            } catch (Exception e) {
                Float f = program.getDefine(arg);
                result.add(f);
            }
        }
        return result;
    }
}
