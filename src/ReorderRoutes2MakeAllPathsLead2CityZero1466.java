import java.util.*;

public class ReorderRoutes2MakeAllPathsLead2CityZero1466 {

    public static void main(String[] args) {

        System.out.println(minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));

    }

    private static int minReorder(int n, int[][] connections) {

        int flips = 0;

        //Create adjacency list.

        Map<Integer, List<Integer>> adjacency = new HashMap<>();

        for (int[] connection : connections) {
            adjacency.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            //We need the below else we will not know the edges with right directions.
            adjacency.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(-connection[0]);
        }

        //BSF starts
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();
            visited[currentVertex] = true;


            for (Integer destVertex : adjacency.getOrDefault(currentVertex, new ArrayList<>())) {
                if (!visited[Math.abs(destVertex)]) {
                    if (destVertex > 0) {
                        flips++;
                    }
                    queue.add(Math.abs(destVertex));
                }
            }

        }



        return flips;
    }



}
