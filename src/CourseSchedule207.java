import java.util.*;

public class CourseSchedule207 {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}));
//        System.out.println(canFinish(2, new int[][]{{0,1},{0,2},{1,2}}));
//        System.out.println(canFinish(2, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
//        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
//        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[0], pr -> new ArrayList<>()).add(p[1]);
        }

        Set<Integer> finishable = new HashSet<>();
        for (Integer key : graph.keySet()) {
            Set<Integer> visited = new HashSet<>();
            boolean canFinish = dfs(graph, key, finishable, visited);
            if (!canFinish) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, Integer key, Set<Integer> finishable, Set<Integer> visited) {

        if (!graph.containsKey(key)) {
            return true;
        }

        if (finishable.contains(key)) {
            return true;
        }

        if (visited.contains(key)) {
            return false;
        }

        visited.add(key);

        boolean canFinish = false;
        for (int course : graph.get(key)) {
            canFinish = dfs(graph, course, finishable, visited);

            if (!canFinish) {
                return false;
            }
            finishable.add(course);
        }

        if (canFinish) {
            finishable.add(key);
            return true;
        } else {
            return false;
        }
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[0], pr -> new ArrayList<>()).add(p[1]);
        }

        return graph;
    }



}
