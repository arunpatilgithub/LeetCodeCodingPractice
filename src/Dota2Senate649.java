import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DDRRR"));
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
    }

    private static String predictPartyVictory(String senate) {

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int N = senate.length();

        for (int index=0; index<N; index++) {

            char c = senate.charAt(index);
            if (c == 'R') {
                rQueue.add(index);
            } else {
                dQueue.add(index);
            }

        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {

            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();

            if (rIndex < dIndex) {
                rQueue.add(rIndex+N);
            } else {
                dQueue.add(dIndex+N);
            }

        }


        return !rQueue.isEmpty() ? "Radiant" : "Dire";

    }


    private static String WRONG_predictPartyVictory(String senate) {

        int rCount = 0;
        int dCount = 0;
        int N = senate.length();

        boolean[] banned = new boolean[N];

        int index = 0;
        while (true) {

            if (!banned[index]) {
                if (index == N - 1) {

                    if (senate.charAt(index) == 'R') {
                        rCount++;
                    } else {
                        dCount++;
                    }

                    if (rCount != dCount) {
                        break;
                    } else {
                        index = -1;
                    }

                } else {

                    if (senate.charAt(index) != senate.charAt(index + 1) && !banned[index+1]) {
                        banned[index + 1] = true;
                    } else {

                        if (senate.charAt(index) == 'R') {
                            rCount++;
                        } else {
                            dCount++;
                        }

                    }

                }
            } else {
                if (index == N - 1) {
                    if (rCount != dCount) {
                        break;
                    } else {
                        index = -1;
                    }
                }
            }


            index++;

        }

        return rCount > dCount ? "Radiant" : "Dire";


    }
}
