import java.util.Arrays;

public class CountingBits338 {

    public static void main(String[] args) {

        Arrays.stream(countBits(4)).forEach(System.out::println);
    }

    private static int[] countBits(int n) {
        int res[] = new int[n + 1];
        for (int i = 1; i <= n; i++)
            res[i] = 1 + res[i & (i - 1)];
        return res;
    }

}
