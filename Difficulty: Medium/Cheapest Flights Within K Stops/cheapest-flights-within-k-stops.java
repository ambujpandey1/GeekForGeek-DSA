class Solution {
static class Pair{
    int first,second;
    
    Pair(int f, int s){
       this.first=f;
       this.second=s;
    }
}

static class tuple{
    int first,second,third;
    
    tuple(int f, int s,int t){
       this.first=f;
       this.second=s;
       this.third=t;
    }
}
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
       
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int m=flights.length;
        
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0)) ;// steps,node,distance
        
        int[] dist=new int[n];
        for(int i=0;i<n;i++) dist[i]=(int)1e9;
        
        dist[src]=0;
        
        while(!q.isEmpty()){
            tuple it=q.peek();
            q.remove();
            int step=it.first;
            int node=it.second;
            int cost=it.third;
            
            
            if(step> k) continue;
            for(Pair itr:adj.get(node)){
                int adjNode=itr.first;
                int edw=itr.second;
                
                if(cost+edw <dist[adjNode] && step<=k){
                    dist[adjNode]=cost+edw;
                    q.add(new tuple(step+1,adjNode,cost+edw));
                }
            }
        }
        
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
        
    }
}