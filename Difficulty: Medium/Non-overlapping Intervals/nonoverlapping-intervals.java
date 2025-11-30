class Solution {
    public int minRemoval(int intervals[][]) {
       Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int n=intervals.length;
        int[] current=intervals[0];
        int count=0;
        for(int i=1;i<n;i++){
          if(intervals[i][0]<current[1]) count++;
          else current=intervals[i];
        }

        return count;
    }
}
