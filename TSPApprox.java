import java.util.ArrayList;
// import java.util.Arrays; // This import statement is not used and can be removed.
import java.util.List;

public class TSPApprox {
    public List<Integer> tspApprox(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        tspUtil(graph, start, visited, path);
        path.add(start);  // returning to start point to complete the cycle
        return path;
    }

    private void tspUtil(int[][] graph, int current, boolean[] visited, List<Integer> path) {
        visited[current] = true;
        path.add(current);

        int closest = -1;
        int closestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[current][i] < closestDistance) {
                closest = i;
                closestDistance = graph[current][i];
            }
        }

        if (closest != -1) {
            tspUtil(graph, closest, visited, path);
        }
    }
}
