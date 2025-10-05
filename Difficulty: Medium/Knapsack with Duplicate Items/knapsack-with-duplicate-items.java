// User function Template for Java

class Solution {
   static  int  helper(int n,int target,int[] arr,int val[],int[][] dp){
        if(n==0){
            if(target>=arr[0]){
            return ((int)target / arr[0])*val[0] ;
            }
            return 0;
            
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int notTake=helper(n-1,target,arr,val,dp);
        int take=Integer.MIN_VALUE;
        if(arr[n]<=target){
            take=val[n]+helper(n,target-arr[n],arr,val,dp);
        }
        
        return dp[n][target]=Math.max(notTake,take);
    }
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int t=capacity;
        int n=wt.length;
        int[][] dp=new int[n][t+1];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(n-1,capacity,wt,val,dp);
    }
}