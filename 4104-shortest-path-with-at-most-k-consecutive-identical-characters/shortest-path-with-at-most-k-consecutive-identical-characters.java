import java.util.*;

class Solution {

    static class State {
        int node;
        int count;
        long cost;

        State(int node, int count, long cost) {
            this.node = node;
            this.count = count;
            this.cost = cost;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // 1. Build adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
        }

        // 2. Distance for each (node, consecutive count) state
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // Starting node has one occurrence of its character
        dist[0][1] = 0;

        // 3. Min heap for Dijkstra
        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        pq.offer(new State(0, 1, 0));

        // 4. Dijkstra
        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int u = curr.node;
            int count = curr.count;
            long cost = curr.cost;

            // Ignore outdated states
            if (cost != dist[u][count]) {
                continue;
            }

            // Destination reached optimally
            if (u == n - 1) {
                return (int) cost;
            }

            // Explore outgoing edges
            for (int[] edge : graph[u]) {

                int v = edge[0];
                int w = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Invalid consecutive character sequence
                if (newCount > k) {
                    continue;
                }

                long newCost = cost + w;

                // Relaxation
                if (newCost < dist[v][newCount]) {

                    dist[v][newCount] = newCost;

                    pq.offer(
                        new State(v, newCount, newCost)
                    );
                }
            }
        }

        return -1;
    }
}