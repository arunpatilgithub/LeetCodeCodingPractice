import java.util.*;

public class CourseScheduleII210 {

    public static void main(String[] args) {
        Arrays.stream(findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}})).forEach(System.out::println);
        //Arrays.stream(findOrder(2,new int[][]{{1,0}})).forEach(System.out::println);
        //Arrays.stream(findOrder(2,new int[][]{{0,1},{1,0}})).forEach(System.out::println);

    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> outputStack = new Stack<>();
        Set<Integer> currentIterationVisited = new HashSet<>();
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);

        for (int i=0; i<numCourses; i++) {

            if (!visited.contains(i)) {
                boolean res = dfs(i,numCourses,graph, visited, outputStack, currentIterationVisited);
                if (!res) {
                    return new int[0];
                }
            }

        }

        int index=0;
        int[] output = new int[numCourses];

        while (!outputStack.isEmpty()) {
            output[index++] = outputStack.pop();
        }

        return output;
    }

    private static boolean dfs(int course, int numCourses, Map<Integer, List<Integer>> graph, Set<Integer> visited,
                               Stack<Integer> outputStack,
                               Set<Integer> currentIterationVisited) {


        if (outputStack.size() == numCourses) {
            return true;
        }

        if (currentIterationVisited.contains(course)) {
            return false;
        }

        currentIterationVisited.add(course);

        boolean res = true;
        if (graph.containsKey(course)) {
            for(int c : graph.get(course)) {

                if (!visited.contains(c)) {
                    res = dfs(c,numCourses, graph, visited, outputStack, currentIterationVisited);
                    if (!res) {
                        return false;
                    }
                }

            }
        }

        if (res) {
            currentIterationVisited.remove(course);
            visited.add(course);
            outputStack.push(course);
            return true;
        } else {
            return false;
        }

    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], l -> new ArrayList<>()).add(pre[0]);
        }

        return graph;

    }


}
