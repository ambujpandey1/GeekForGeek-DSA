class Solution {
    
    static void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    
    static void dfs3(int node,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs3(it,vis,adj);
            }
        }
        
    }
    
    
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v=adj.size();
        int vis[]=new int[v];
        Stack<Integer> st=new Stack<>();
        
        // find finishing time and sort
        for(int i=0;i<v;i++){
            if(vis[i]==0) dfs(i,vis,adj,st);
        }
        
        // transpose graph or reversersed
        ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjT.add(new ArrayList<>());
        }
        
        for(int i=0;i<v;i++){
            vis[i]=0;
            for(Integer it:adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        
        int scc=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if(vis[node]==0){
                scc++;
                dfs3(node,vis,adjT);
            }
        }
        
        return scc;
    }
}