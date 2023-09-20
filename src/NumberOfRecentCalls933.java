import java.util.*;

public class NumberOfRecentCalls933 {

    public static void main(String[] args) {

        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(642));
        System.out.println(recentCounter.ping(1849));
        System.out.println(recentCounter.ping(4921));
        System.out.println(recentCounter.ping(5936));
        System.out.println(recentCounter.ping(5957));

    }

    static class RecentCounter {

        private Queue<Integer> recentCalls;

        public RecentCounter() {
            recentCalls = new LinkedList<>();
        }

        public int ping(int t) {

            recentCalls.add(t);

            while (!recentCalls.isEmpty() && recentCalls.peek() < t - 3000) {
                recentCalls.poll();
            }

            return recentCalls.size();
        }
    }
}
