//Minimum edges to reverse to make path from a source to a destination
package Greedy_Algo;
import java.util.*;
public class MinimumOpToDest{
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node, path;
        public Pair(int n, int p) {
            this.node = n;
            this.path = p;
        }

        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    // Make undirected by adding reverse edge with cost 1
    public static void makeUndirect(ArrayList<Edge>[] graph) {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            for (Edge e : new ArrayList<>(graph[i])) { // Avoid ConcurrentModification
                boolean reverseExists = false;
                for (Edge rev : graph[e.dest]) {
                    if (rev.dest == i) {
                        reverseExists = true;
                        break;
                    }
                }
                if (!reverseExists) {
                    graph[e.dest].add(new Edge(e.dest, i, 1)); // Reverse edge with weight 1
                }
            }
        }
    }

    public static int dijkstra(ArrayList<Edge>[] graph, int src, int dest) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int u = curr.node;

            for (Edge e : graph[u]) {
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist[dest];
    }

    public static void main(String[] args) throws Exception {
        int V = 7;
        int src = 0;
        int dst = 6;
        int[][] edges = {
            {0, 1}, {2, 1}, {2, 3}, {6, 3}, {6, 4}, {4, 5}, {5, 1}
        };
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(new Edge(u, v, 0)); // original edge has weight 0
        }

        System.out.println("Making undirected graph...");
        makeUndirect(graph);

        // Now find how many reverse operations required from src to dest.
        int result = dijkstra(graph, src, dst);
        if (result == Integer.MAX_VALUE) {
            System.out.println("Path not reachable");
        } else {
            System.out.println("Minimum reverse required: " + result);
        }
    }
}
