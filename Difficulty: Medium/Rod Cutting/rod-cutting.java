class Solution {
     int  helper(int n,int target,int[] arr,int[][] dp){
        if(n==0){
            return target *arr[0];
           
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int notTake=helper(n-1,target,arr,dp);
        int take=Integer.MIN_VALUE;
        int rodLength = n + 1;
        if(rodLength<=target){
            take=arr[n]+helper(n,target-rodLength,arr,dp);
        }
        return dp[n][target]=Math.max(notTake,take);
    }
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int t=n;
        int dp[][] =new int[n][t+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return helper(n-1,t,price,dp);
    }
}