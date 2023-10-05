import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan901 {

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));

    }

    static class StockSpanner {

        Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {

            int span = 1;

            while (!stack.empty() && stack.peek()[0]<= price) {
                span = span + stack.pop()[1];
            }
            stack.push(new int[]{price, span});

            return span;
        }
    }

}
