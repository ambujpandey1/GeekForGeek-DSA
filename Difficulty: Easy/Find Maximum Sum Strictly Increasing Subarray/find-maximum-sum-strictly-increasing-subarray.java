// User function Template for Java

public class Solution {

  public static int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int maxSum=sum;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
                
            }else{
                sum=nums[i];
            }
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
    static int maxsum_SIS(int arr[], int n) {
        // Your code goes here
        return maxAscendingSum(arr);
    }
}