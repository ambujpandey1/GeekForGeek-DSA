// User function Template for Java

class Solution {
    public static int maxSkill(int[] nums) {
        // code here
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        // copy original nums into arr starting at index 1
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        
       
      
      int[][] dp=new int[arr.length+2][arr.length+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                 int ans = Integer.MIN_VALUE;
                for (int idx = i; idx <= j; idx++) {
                  int cost = arr[i - 1] * arr[idx] * arr[j + 1]
                     + dp[i][ idx - 1]
                     + dp[idx + 1][ j];
            ans = Math.max(ans, cost);
            
            }
            dp[i][j]=ans;
            }
        }
        return dp[1][n];
    }
}
