// User function Template for Java

class Solution {
    // first index i such that arr[i] >= t, or arr.length if none
    private static int lowerBound(int[] arr, int t){
        int ans = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= t) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    // first index i such that arr[i] > t, or arr.length if none
    private static int firstGreaterThan(int[] arr, int t){
        int ans = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > t) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    // returns [count <= target, count >= target]
    int[] getMoreAndLess(int[] arr, int target) {
        int n = arr.length;
        int lessOrEqual = firstGreaterThan(arr, target);   // count of elements <= target
        int firstGE = lowerBound(arr, target);             // first index >= target
        int greaterOrEqual = n - firstGE;                  // count of elements >= target
        
        return new int[] { lessOrEqual, greaterOrEqual };
    }
}
