class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
       ArrayList<int[]> res=new ArrayList<>();
     int i=0;
     int n=intervals.length;

     // add before overlaping
     while(i<n && intervals[i][1]<newInterval[0]){
        res.add(intervals[i]);
        i++;
     }

     // merged overlapping interverls

     while(i<n && intervals[i][0]<=newInterval[1]){
        newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
        newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
        i++;
     }
     res.add(newInterval);

     // add after overlapping intervals
     while(i<n){
        res.add(intervals[i]);
        i++;
     }

     return res;
        
    }
}
