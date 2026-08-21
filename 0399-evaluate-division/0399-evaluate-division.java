import java.util.*;
class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new Edge(b, value));
            graph.get(b).add(new Edge(a, 1.0 / value));
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
                continue;
            }
            if (start.equals(end)) {
                result[i] = 1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            result[i] = dfs(graph, start, end, 1.0, visited);
        }
        return result;
    }
    private double dfs(
            Map<String, List<Edge>> graph,
            String current,
            String target,
            double product,
            Set<String> visited) {
        if (current.equals(target)) {
            return product;
        }
        visited.add(current);
        for (Edge edge : graph.get(current)) {
            if (visited.contains(edge.to)) {
                continue;
            }
            double answer = dfs(
                    graph,
                    edge.to,
                    target,
                    product * edge.value,
                    visited
            );
            if (answer != -1.0) {
                return answer;
            }
        }
        return -1.0;
    }
    static class Edge {
        String to;
        double value;
        Edge(String to, double value) {
            this.to = to;
            this.value = value;
        }
    }
}