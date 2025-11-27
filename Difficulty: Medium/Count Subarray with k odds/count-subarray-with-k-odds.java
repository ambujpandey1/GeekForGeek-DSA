class Solution {
     public static int numSubarraysWithLessEqualSum(int[] nums, int goal) {
        int l=0;
        int n=nums.length;
        int sum=0;
        int count=0;
        if(goal<0) return 0;

        for(int r=0;r<n;r++){
            sum+=(nums[r]%2);

            while(sum>goal){
                sum-=(nums[l]%2);
                l++;
            }
            
            count+=(r-l+1);
        }

        return count;
    }
   
    public int countSubarrays(int[] nums, int k) {
        // code here
        return numSubarraysWithLessEqualSum(nums,k)-numSubarraysWithLessEqualSum(nums,k-1);
    }
}
