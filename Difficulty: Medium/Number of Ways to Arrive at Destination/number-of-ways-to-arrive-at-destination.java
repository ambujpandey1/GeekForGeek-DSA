// User function Template for Java
import java.util.*;

class Solution {

    static class Pair {
        long first; // distance or weight
        int second; // node
        Pair(long f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.size(); i++) {
            int u = roads.get(i).get(0);
            int v = roads.get(i).get(1);
            int wt = roads.get(i).get(2);
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        int mod = (int) 1e9 + 7;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        pq.add(new Pair(0L, 0)); // (distance, node)

        while (!pq.isEmpty()) {
            long dis = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();

            if (dis > dist[node]) continue; // skip outdated entries

            for (Pair it : adj.get(node)) {
                int adjNode = it.second;
                long edw = it.first;

                if (dis + edw < dist[adjNode]) {
                    dist[adjNode] = dis + edw;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } else if (dis + edw == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
