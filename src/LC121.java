public class LC121 {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfitSlidingWindow(new int[]{7,6,4,3,1}));
    }

    static int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }

        return maxProfit;
    }

    static int maxProfitSlidingWindow(int[] prices) {

        if (prices.length == 1) {
            return 0;
        }

        int maxProfit = 0;
        int l = 0;
        int r = 1;

        while (r<prices.length) {

            if (prices[l]<prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r]-prices[l]);
                r++;
            } else {
                l=r;
                r++;
            }
        }

        return maxProfit;

    }
}
