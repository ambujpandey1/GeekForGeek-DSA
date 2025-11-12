class Solution {
    static class Pair{
        int distance, node;
        Pair(int d,int n){
            this.distance=d;
            this.node=n;
        }
    }
    public int spanningTree(int V, int[][] edge) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int wt=edge[i][2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        
        int vis[]=new int[V];
        int sum=0;
        
        pq.add(new Pair(0,0));
        
        while(pq.size()>0){
            int wt=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            
            if(vis[node]==1) continue;
            
            vis[node]=1;
            sum+=wt;
            
            for(Pair it:adj.get(node)){
                int adjNode=it.node;
                int  adW=it.distance;
                
                if(vis[adjNode]==0){
                    pq.add(new Pair(adW,adjNode));
                }
            }
        }
        
        return sum;
    }
}
