import ru.nsu.ccfit.sergeyBiryukov.StackCalculator.StackCalculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StackCalculator calculator;
        if(args.length == 0) {
            calculator = new StackCalculator();
        } else {
            calculator = new StackCalculator(args[0]);
        }
        try {
            calculator.Run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}