// User function Template for Java

class Solution {
    public int longestSubarray(int arr[]) {
        // write code here
        int curr = 0;
        int maxi = 0;

        for (int num : arr) {
            if (num >= 0) {
                curr++;
                maxi = Math.max(maxi, curr);
            } else {
                curr = 0; // break the subarray
            }
        }

        return maxi;
    }
}