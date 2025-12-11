class Solution {
    public boolean search(int[] nums, int target) {
         int l=0;
        int h=nums.length-1;
        int mid=l+(h-l)/2;

        while(l<=h){
            mid=l+(h-l)/2;
            if(nums[mid]==target) return true;
           if(nums[l]==nums[mid] && nums[mid]==nums[h]){
            l=l+1;
            h=h-1;
            continue;
           }
           // left portion sorted
            if(nums[l]<=nums[mid]){
                if(nums[l] <= target && target < nums[mid]) h=mid-1;
                else l=mid+1;
            }
            // right portion sorted
            else{
               if(nums[mid] <= target && target <= nums[h]) l=mid+1;
                else h=mid-1; 
            }
        }
        return false;   
        
    }
}
