class Solution {
    public static class Pair {
        int node, weight;
        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }
    
    public static int[] dijkstra(int v, ArrayList<ArrayList<Pair>> adj, int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.weight - y.weight);
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) dist[i] = (int) 1e9;
        
        dist[s] = 0;
        pq.add(new Pair(s, 0));
        
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().weight;
            pq.remove();
            
            if (dis > dist[node]) continue; // skip outdated
            
            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edgeWeight = it.weight;
                
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(v, wt));
            // adj.get(v).add(new Pair(u, wt));  // undirected
        }
        
        return dijkstra(V, adj, src);
    }
}
