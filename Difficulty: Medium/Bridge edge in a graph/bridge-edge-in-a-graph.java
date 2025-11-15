class Solution {
     int timer = 1;

    void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj,
             int[] tin, int[] low, List<List<Integer>> bridges) {

        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for (int it : adj.get(node)) {

            if (it == parent) continue;

            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, bridges);

                low[node] = Math.min(low[node], low[it]);

                // bridge condition
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it));
                }

            } else {
                // back-edge condition
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        // run for all components
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0)
                dfs(i, -1, vis, adj, tin, low, bridges);
        }

        return bridges;
    }
    
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // convert edges[][] into list of pairs
        List<List<Integer>> connections = new ArrayList<>();
        for (int[] e : edges) {
            connections.add(Arrays.asList(e[0], e[1]));
        }

        // get all bridges
        List<List<Integer>> bridges = criticalConnections(V, connections);

        // check undirected pair
        for (List<Integer> b : bridges) {
            int u = b.get(0);
            int v = b.get(1);

            if ((u == c && v == d) || (u == d && v == c))
                return true;
        }

        return false;
        
        
        
    }
}