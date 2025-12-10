class Solution {
  private static  boolean canwePlace(int[] arr, int dist, int cows){
        int cntCows=1;
        int last=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if((arr[i]-last)>=dist){
                cntCows++;
                last=arr[i];
            }
            if(cntCows>=cows) return true;
        }
        return false;
    }
    public int aggressiveCows1(int[] stalls, int k) {
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int s:stalls){
            min=Math.min(s,min);
            max=Math.max(s,max);
        }
        
        for(int i=1;i<=(max-min);i++){
            if(canwePlace(stalls,i,k)==true) continue;
            else return (i-1);
        }
        
        return -1;
    }
    public int aggressiveCows(int[] stalls, int k) {
      Arrays.sort(stalls);  
     //  return aggressiveCows1(stalls,k); // Brute force
     
      int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int s:stalls){
            min=Math.min(s,min);
            max=Math.max(s,max);
        }
     
     int low=1;
     int high=(max-min);
     
     while(low<=high){
         int mid=(low+high)/2;
          if(canwePlace(stalls,mid,k)==true){
             low=mid+1; 
          }else high=mid-1;
     }
     
     return high;
    }
}