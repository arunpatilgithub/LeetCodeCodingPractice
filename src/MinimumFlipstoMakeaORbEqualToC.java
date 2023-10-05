public class MinimumFlipstoMakeaORbEqualToC {

    public static void main(String[] args) {
        System.out.println(minFlips(2,6,5));
    }

    //Not my solution as I didn't know how to do bit manipulation before this.
    private static int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {

            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            /**
                If c has a 1 at that position:
                If both a and b have 0s at that position, then one of them should be flipped to 1.
                We can flip either aa or bb, but not both. So, one flip is required in this case.
                If at least one of aa or bb has a 1 at that position, no flips are needed.
            */

            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) {
                    flips++;
                }
            }

            /**
            If cc has a 0 at that position:
            If both a and b have 0s at that position, no flips are needed.
            If a has a 1 and bb has a 0 at that position, a should be flipped. One flip is needed.
            If b has a 1 and aa has a 0 at that position, b should be flipped. One flip is needed.
            If both a and b have 1s at that position,
            both should be flipped to 0 to make a OR b=0a OR b=0 at that bit. So, two flips are required.
             */

            else {
                if (bitA == 1) {
                    flips++;
                }
                if (bitB == 1) {
                    flips++;
                }
            }
        }
        return flips;
    }


}
