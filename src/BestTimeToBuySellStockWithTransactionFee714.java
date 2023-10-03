public class BestTimeToBuySellStockWithTransactionFee714 {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }

    private static int maxProfit(int[] prices, int fee) {

        int buy = Integer.MIN_VALUE; //profit if I buy.
        int profit = 0;  //profit if I sell

        for (int i=0; i<prices.length; i++) {
            buy = Math.max(buy, profit - prices[i]);
            profit = Math.max(profit, buy + prices[i]-fee);
        }

        return profit;

    }

}
