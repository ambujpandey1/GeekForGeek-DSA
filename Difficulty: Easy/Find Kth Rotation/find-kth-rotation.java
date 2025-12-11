class Solution {
    public int findKRotation(int nums[]) {
  int l = 0, r = nums.length - 1;

        // If already sorted (no rotation)
        if(nums[l] <= nums[r]) 
            return 0;

        while(l < r){
            int m = l + (r - l) / 2;
            
            // Minimum element is on the right half
            if(nums[m] > nums[r]){
                l = m + 1;
            } 
            // Minimum element is on the left half including mid
            else {
                r = m;
            }
        }

        // l (or r) is now the index of smallest element → rotation count
        return l;
        
    }
}