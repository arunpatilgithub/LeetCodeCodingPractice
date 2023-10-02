import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber1137 {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    private static int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,1);


        return recur(n, cache);
    }

    private static int recur(int n, Map<Integer, Integer> cache) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int a = recur(n-1, cache);
        cache.put(n-1,a);
        int b = recur(n-2, cache);
        cache.put(n-2,b);
        int c = recur(n-3, cache);
        cache.put(n-3,a);

        return a + b + c;

    }
}
