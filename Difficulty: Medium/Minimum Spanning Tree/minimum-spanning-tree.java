class DisjointSet {
    int[] parent, size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    void unionSet(int x, int y) {
        int ulp_x = find(x);
        int ulp_y = find(y);
        if (ulp_x == ulp_y) return;

        // union by size
        if (size[ulp_x] < size[ulp_y]) {
            parent[ulp_x] = ulp_y;
            size[ulp_y] += size[ulp_x];
        } else {
            parent[ulp_y] = ulp_x;
            size[ulp_x] += size[ulp_y];
        }
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int _src, int _dest, int _wt) {
        this.src = _src;
        this.dest = _dest;
        this.weight = _wt;
    }

    // Sort edges based on weight
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Solution {
    // static class Pair{
    //     int distance, node;
    //     Pair(int d,int n){
    //         this.distance=d;
    //         this.node=n;
    //     }
    // }
    // public int spanningTreePrims(int V, int[][] edge) {
    //     // code here
    //     PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        
    //     ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
    //     for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
    //     for(int i=0;i<edge.length;i++){
    //         int u=edge[i][0];
    //         int v=edge[i][1];
    //         int wt=edge[i][2];
    //         adj.get(u).add(new Pair(wt,v));
    //         adj.get(v).add(new Pair(wt,u));
    //     }
        
    //     int vis[]=new int[V];
    //     int sum=0;
        
    //     pq.add(new Pair(0,0));
        
    //     while(pq.size()>0){
    //         int wt=pq.peek().distance;
    //         int node=pq.peek().node;
    //         pq.remove();
            
    //         if(vis[node]==1) continue;
            
    //         vis[node]=1;
    //         sum+=wt;
            
    //         for(Pair it:adj.get(node)){
    //             int adjNode=it.node;
    //             int  adW=it.distance;
                
    //             if(vis[adjNode]==0){
    //                 pq.add(new Pair(adW,adjNode));
    //             }
    //         }
    //     }
        
    //     return sum;
    // }
    
    public int spanningTree(int V, int[][] edges){
       Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            if (ds.find(u) != ds.find(v)) {
                mstWt += wt;
                ds.unionSet(u, v);
            }
        }

        return mstWt;
    }
}
