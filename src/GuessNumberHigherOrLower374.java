public class GuessNumberHigherOrLower374 {

    public static void main(String[] args) {


        System.out.println(guessNumber(30));
    }

    private static int guessNumber(int n) {

        int l = 1;
        int r = n;

        if (guess(1) == 0) {
            return 1;
        }

        if (guess(n) == 0) {
            return n;
        }

        while (true) {

            int mid = l + (r-l) / 2;

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                r = mid-1;
            } else {
                l = mid+1;
            }

        }


    }

    private static int guess(int num) {
        int pick = 4;
        if (num == 4) {
            return 0;
        } else if (num < pick) {
            return 1;
        } else {
            return -1;
        }

    }

}
