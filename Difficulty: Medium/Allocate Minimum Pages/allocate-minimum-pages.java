class Solution {
     boolean isPossible(int[] weights, int capacity, int days) {
        int currWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {
            if (currWeight + w > capacity) {
                requiredDays++;
                currWeight = w;
            } else {
                currWeight += w;
            }
        }
        return requiredDays <= days;
    }
    public int findPages(int[] nums, int k) {
        int low = 0, high = 0;
if (k > nums.length) return -1;

        for (int w : nums) {
            low = Math.max(low, w); // max weight
            high += w;              // total weight
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(nums, mid, k)) {
                high = mid - 1;   // try smaller capacity
            } else {
                low = mid + 1;    // increase capacity
            }
        }
        return low; 
    }
}