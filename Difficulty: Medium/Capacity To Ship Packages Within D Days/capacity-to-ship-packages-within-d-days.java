// User function Template for Java

class Solution {
    private static boolean isPossible(int[] weights, int capacity, int days) {
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
    static int leastWeightCapacity(int[] weights, int n, int d) {
     
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // max weight
            high += w;              // total weight
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(weights, mid, d)) {
                high = mid - 1;   // try smaller capacity
            } else {
                low = mid + 1;    // increase capacity
            }
        }
        return low;
        
    }
};