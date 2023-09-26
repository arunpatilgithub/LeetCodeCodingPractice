import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Collectors;

public class EvaluateDivision399 {

    public static void main(String[] args) {

        List<List<String>> equations = Arrays.stream(new String[][]{{"a","b"},{"b","c"}})
                .map(Arrays::asList)
                .collect(Collectors.toList());

        double[] values = new double[]{2.0,3.0};

        List<List<String>> queries = Arrays.stream(new String[][]{{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}})
                .map(Arrays::asList)
                .collect(Collectors.toList());


        double[] output = calcEquation(equations, values, queries);

        Arrays.stream(output).forEach(System.out::println);

    }

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


        var graph = buildGraph(equations, values);

        double[] output = new double[queries.size()];

        int currentIndex = 0;
        for (List<String> query : queries) {

            String src = query.get(0);
            String dest = query.get(1);

            output[currentIndex] = dfs(graph, src, dest, new HashSet());
            currentIndex++;

        }

        return output;
    }

    private static double dfs(Map<String, List<Node>> graph,
                            String src,
                            String dest,
                            Set<String> visited) {

        if (!graph.containsKey(src) && !graph.containsKey(dest)) {
            return -1;
        }

        if (src.equalsIgnoreCase(dest)) {
            return 1;
        }

        visited.add(src);
        for (Node n : graph.get(src)) {
            if (!visited.contains(n.dest)) {
                double output = dfs(graph, n.dest, dest, visited);
                if (output != -1) {
                    return output * n.weight;
                }
            }
        }

        return -1;

    }

    private static Map<String, List<Node >> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, List<Node >> graph = new HashMap<>();

        int index =0;
        for (List<String> eq : equations) {

            String src = eq.get(0);
            String dest = eq.get(1);

            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Node(dest, values[index]));
            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Node(src, 1/values[index]));
            index++;

        }

        return graph;

    }


    static class  Node {
        String dest;
        double weight;

        public Node(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }

    }

}
