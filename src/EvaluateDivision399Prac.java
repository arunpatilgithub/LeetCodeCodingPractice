import java.util.*;
import java.util.stream.Collectors;

public class EvaluateDivision399Prac {

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

        Map<String, List<Node>> graph = buildGraph(equations, values);

        double[] output = new double[queries.size()];
        int index=0;
        for (List<String> query : queries) {
            String from = query.get(0);
            String to = query.get(1);

            double queryOutput = dfs(from, to, graph, new HashSet<>());

            output[index] = queryOutput;
            index++;
        }

        return output;
    }

    private static double dfs(String from, String to, Map<String, List<Node>> graph, HashSet<String> visited) {

        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            return -1;
        }

        if (to.equals(from)) {
            return 1;
        }

        visited.add(from);

        for (Node n : graph.get(from)) {

            if (!visited.contains(n.to)) {
                double output = dfs(n.to, to,graph,visited);

                if (output != -1) {
                    return output * n.cost;
                }
            }

        }

        return -1;


    }

    private static Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, List<Node>> graph = new HashMap<>();

        for (int i=0; i< values.length; i++) {

            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);

            graph.computeIfAbsent(from, l -> new ArrayList<>()).add(new Node(to,values[i]));
            graph.computeIfAbsent(to, l -> new ArrayList<>()).add(new Node(from,1/values[i]));

        }

        return graph;

    }




    private static class Node {

        String to;
        double cost;

        public Node(String to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }



}
