import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision735 {

    public static void main(String[] args) {

        Arrays.stream(asteroidCollision(new int[]{-2,-1,1,2})).forEach(System.out::println);
        System.out.println("**");
        Arrays.stream(asteroidCollision(new int[]{10,2,-5})).forEach(System.out::println);
        System.out.println("**");
        Arrays.stream(asteroidCollision(new int[]{5,10,-5})).forEach(System.out::println);
        System.out.println("**");
        Arrays.stream(asteroidCollision(new int[]{8,-8})).forEach(System.out::println);
    }

    private static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                boolean shouldPush = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.pop();

                    if (Math.abs(a) == top) {
                        shouldPush = false;
                        break;
                    } else if (Math.abs(a) < top) {
                        stack.push(top);
                        shouldPush = false;
                        break;
                    }
                }

                if (shouldPush) {
                    stack.push(a);
                }
            }
        }


        int[] output = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }

        return output;

    }

}
