import java.util.Arrays;
import java.util.Comparator;

public class KruskalMST {
    class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public Edge[] kruskalMST(Edge[] edges, int V) {
        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));
        int[] parent = new int[V];
        Edge[] result = new Edge[V - 1];
        int e = 0, i = 0;

        for (int j = 0; j < V; j++) {
            parent[j] = j;
        }

        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }
        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }
}
