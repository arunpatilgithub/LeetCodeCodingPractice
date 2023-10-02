public class KokoEatingBananas875 {

    public static void main(String[] args) {

        //System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }


    private static int minEatingSpeed2(int[] piles, int h) {
        int l = 1;
        int r = 0;  // Initializing to 0 to be updated later.

        for (int p : piles) {
            r = Math.max(r, p);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int k = 0;
            for (int p : piles) {
                k += (p + mid - 1) / mid;  // Another way to achieve Math.ceil without using floating point division.
            }

            if (k > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }



    private static int minEatingSpeed(int[] piles, int h) {

        long l = 1;

        long r = 0;

        for(int p : piles) {
            r = Math.max(r, p);
        }

        while (l <=r) {

            long mid = l + (r - l) / 2;

            long k = 0;
            for (long p : piles) {
                //remember this new way of calculating ceil val.
                k = k + (p+mid-1)/mid;
            }

            if (k <= h) {
                r = mid - 1;
            } else {
                l = mid+1;
            }


        }

        return (int)l;
    }


}
