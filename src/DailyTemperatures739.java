import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

    public static void main(String[] args) {

        Arrays.stream(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})).forEach(System.out::println);
        //Arrays.stream(dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})).forEach(System.out::println);

    }

    private static int[] dailyTemperatures(int[] temperatures) {

        int output[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i< temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDayIndex = stack.pop();
                output[prevDayIndex] = i - prevDayIndex;
            }
            stack.push(i);

        }


        return output;
    }

}
