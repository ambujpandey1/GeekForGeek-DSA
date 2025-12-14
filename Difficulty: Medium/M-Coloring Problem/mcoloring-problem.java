class Solution {

    private static boolean isPossible(int node, int colr, 
                                      ArrayList<ArrayList<Integer>> adj, 
                                      int[] color) {
        for (int it : adj.get(node)) {
            if (color[it] == colr) return false;
        }
        return true;
    }

    private static boolean solve(int node, int m, int v,
                                 ArrayList<ArrayList<Integer>> adj,
                                 int[] color) {
        if (node == v) return true;

        for (int colr = 1; colr <= m; colr++) {
            if (isPossible(node, colr, adj, color)) {
                color[node] = colr;

                if (solve(node + 1, m, v, adj, color))
                    return true;

                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    boolean graphColoring(int v, int[][] edges, int m) {

        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], w = e[1];
            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        // Step 2: Color array
        int[] color = new int[v];

        // Step 3: Backtracking
        return solve(0, m, v, adj, color);
    }
}
