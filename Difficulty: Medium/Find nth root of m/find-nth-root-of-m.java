class Solution {
    public int nthRoot(int n, int m) {
         if (m == 0) return 0;
        if (m == 1 || n == 1) return m;
       // code here
        int low=1;
        int high=m;
        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;
            long value=1;
            for(int i=0;i<n;i++){
                value*=mid;
                if(value>m) break;
            }
            if((int)value==m) return mid;
            else if(value<m){
                
                low=(int)mid+1;
            }else{
                high=(int)mid-1;
            }
        }
        
        return -1;
        
    }
}