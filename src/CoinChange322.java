import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class CoinChange322 {

    private static int mincoins;

    public static void main(String[] args) {

        //System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
    }

    private static int coinChange(int[] coins, int amount) {

        mincoins = Integer.MAX_VALUE;
        int[] memo = new int[coins.length];

        for (int i=0; i<coins.length; i++) {
            backtrack(coins, i, amount, 0, memo);
        }

        return mincoins == Integer.MAX_VALUE ? -1 : mincoins;

    }

    private static void backtrack(int[] coins, int i, int amount, int coinCount, int[] memo) {

        if (coinCount > mincoins) {
            return;
        }

        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            mincoins = Math.min(mincoins, coinCount);
            return;
        }

        for (int index=i; index<coins.length; index++) {
            backtrack(coins, index, amount-coins[index],coinCount+1, memo);
        }

        memo[coins[i]] = coinCount;

    }

}
