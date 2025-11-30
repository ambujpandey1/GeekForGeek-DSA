class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] intervals) {
 int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> ans=new ArrayList<>();
        int current[]=intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=current[1]){
                current[1]=Math.max(current[1],intervals[i][1]);
            }else{
                ans.add(current);
                current=intervals[i];
            }
            
        }
        ans.add(current);

        return ans;

        
    }
}