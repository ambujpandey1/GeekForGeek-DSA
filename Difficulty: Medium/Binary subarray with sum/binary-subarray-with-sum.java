// User function Template for Java

class Solution {
    public static int numSubarraysWithLessEqualSum(int[] nums, int goal) {
        int l=0;
        int n=nums.length;
        int sum=0;
        int count=0;
        if(goal<0) return 0;

        for(int r=0;r<n;r++){
            sum+=nums[r];

            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            
            count+=(r-l+1);
        }

        return count;
    }
   
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        return numSubarraysWithLessEqualSum(arr,target)-numSubarraysWithLessEqualSum(arr,target-1);
    }
}