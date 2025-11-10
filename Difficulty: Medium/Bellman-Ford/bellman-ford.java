// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int []dist=new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;
        
        for(int i=0;i<V-1;i++){
            for(int[] ed:edges){
                int u=ed[0];
                int v=ed[1];
                int wt=ed[2];
                
                if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        
        // for finding the -Ve cycle
        // relax Nth iteration
        for(int[] ed:edges){
                int u=ed[0];
                int v=ed[1];
                int wt=ed[2];
                
                if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                    int temp[]=new int[1];
                    temp[0]=-1;
                    return temp;
                }
            }
        
        return dist;
    }
}
