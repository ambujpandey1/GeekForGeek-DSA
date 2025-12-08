class Solution {
    int upperBound(int[] mat, int x, int n){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid]>x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            
            
        }
        return ans;
    }
    int countSmallEqual(int[][] mat, int n, int m,int x){
        int cnt=0;
        for(int i=0;i<n;i++){
            cnt+=upperBound(mat[i],x,m);
        }
        return cnt;
    }
    public int median(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
         // find global min and max
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (mat[i][0] < low) low = mat[i][0];
            if (mat[i][m - 1] > high) high = mat[i][m - 1];
        }
        int req=(n*m)/2;
        
        while(low<=high){
            int mid=(low+high)/2;
            int smallEqual=countSmallEqual(mat,n,m,mid);
            if(smallEqual<=req) low=mid+1;
            else high=mid-1;
        }
        
        return low;
    }
}