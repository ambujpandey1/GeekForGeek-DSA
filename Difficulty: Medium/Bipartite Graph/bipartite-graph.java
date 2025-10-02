class Solution {
    
    boolean CheckBfs(int start,int v,List<Integer>[] adj,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it:adj[node]){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]) return false;
            }
        }
        return true;
        
    }
    
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int color[]=new int[V];
        for(int i=0;i<V;i++) color[i]=-1;
        
         // Build adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]); // undirected graph
        }
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(CheckBfs(i,V,adj,color)==false) return false;
            }
        }
        return true;
    }
}