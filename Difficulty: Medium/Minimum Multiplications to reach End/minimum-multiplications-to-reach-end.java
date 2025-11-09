// User function Template for Java

class Solution {
    static class Pair{
        int first,second;
        Pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {


           if (start == end) return 0;

        int n=arr.length;
        Queue<Pair> q=new LinkedList<>();
        int[] dist=new int[100000];
        
        
        int mod=100000;
        Arrays.fill(dist,(int)1e9);
        dist[start]=0;
        q.add(new Pair(0,start));// steps,num
        
        while(!q.isEmpty()){
             Pair p = q.poll();
            int steps = p.first;
            int node = p.second;
           
            if (steps > dist[node]) continue;
            for(int i=0;i<n;i++){
                int num=(node*arr[i]) % mod;
                if(steps+1<dist[num]){
                    dist[num]=steps+1;
                    if(num==end) return steps+1;
                q.add(new Pair(steps+1,num));
                }
                
            }
        }
        return -1;
    }
}
