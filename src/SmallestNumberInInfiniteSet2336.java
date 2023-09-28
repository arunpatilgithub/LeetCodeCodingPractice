import java.util.*;

public class SmallestNumberInInfiniteSet2336 {

    public static void main(String[] args) {

        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();



        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());

        smallestInfiniteSet.addBack(10);

        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());


//        smallestInfiniteSet.addBack(3);
//
//        System.out.println(smallestInfiniteSet.popSmallest());
//        System.out.println(smallestInfiniteSet.popSmallest());
    }

    static class SmallestInfiniteSet {

        PriorityQueue<Integer> heap;
        Set<Integer> popped;
        int nextNumber;

        public SmallestInfiniteSet() {
            heap = new PriorityQueue<>();
            popped = new HashSet<>();
            nextNumber = 1;
        }

        public int popSmallest() {
            int toReturn;
            if (heap.isEmpty()) {
                toReturn = nextNumber++;
            } else {
                toReturn = heap.poll();
                if(nextNumber == toReturn) {
                    nextNumber++;
                }
            }
            popped.add(toReturn);
            return toReturn;
        }

        public void addBack(int num) {

            if (popped.contains(num)) {
                heap.add(num);
                popped.remove(num);
            }
        }
    }

}
