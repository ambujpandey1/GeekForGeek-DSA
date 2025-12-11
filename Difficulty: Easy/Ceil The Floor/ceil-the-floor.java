// User function Template for Java

class Solution {
    // returns index of first element >= t (ceil)
    private static int lowerBound(int[] arr, int t){
        int ans = -1;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= t){
                ans = mid;
                high = mid - 1;   // go left for smaller >= t
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // returns index of last element <= t (floor)
    private static int upperBound(int[] arr, int t){
        int ans = -1;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] <= t){
                ans = mid;        // valid floor
                low = mid + 1;    // go right for larger <= t
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int lb = lowerBound(arr, x); // ceil index
        int ub = upperBound(arr, x); // floor index

        int[] ans = new int[2];

        // floor
        if(ub == -1) ans[0] = -1;
        else ans[0] = arr[ub];

        // ceil
        if(lb == -1) ans[1] = -1;
        else ans[1] = arr[lb];

        return ans;
    }
}
