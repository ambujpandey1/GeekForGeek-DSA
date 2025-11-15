class Solution {
    
     int timer = 1;

    void dfs(int node, int parent, int[] vis,
             int[] tin, int[] low,int[] mark, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child=0;
        for (Integer it : adj.get(node)) {

            if (it == parent) continue;

            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark,adj);

                low[node] = Math.min(low[node], low[it]);

                // bridge condition
                if (low[it] >= tin[node] && parent!=-1) {
                    mark[node]=1;
                }
                child++;

            } else {
                // back-edge condition
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        
        if(child>1 && parent==-1) mark[node]=1;
    }
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark=  new int[n];
        

        // run for all components
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0)
                dfs(i, -1, vis, tin, low,mark,adj );
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mark[i]==1) ans.add(i);
        }
        if(ans.size()==0) ans.add(-1);
        
        return ans;
        
    }
}