class Solution {
    static int lis(int nums[]) {
        
          int n=nums.length;
  

    // Tabulation
    int dp[][]=new int[n+1][n+1];
    for(int idx=n-1;idx>=0;idx--){
        for(int pidx=n-1;pidx>=-1;pidx-- ){
        int notTake=0+dp[idx+1][pidx+1];
        int take=0;
        if(pidx==-1 || nums[idx]>nums[pidx]){
            take=1+dp[idx+1][idx+1];
        }
       int max=Math.max(take,notTake);
        dp[idx][pidx+1]= max;
        }
    }
    return dp[0][0];
    }
}