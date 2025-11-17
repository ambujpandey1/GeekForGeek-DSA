// User function Template for Java

class Solution {
     static long[] temp;

    private static int merge(long[] arr, int low, int mid, int high) {
        int cnt = 0;

        // Count reverse pairs first (separate logic)
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) i++;
            else {
                cnt += (mid - i + 1);
                j++;
            }
        }

        // Merge sorted halves
        i = low;
        j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        // Copy back
        for (int t = low; t <= high; t++)
            arr[t] = temp[t];

        return cnt;
    }

    private static int mergeSort(long[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int cnt = 0;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);

        return cnt;
    }


    static int countPairs(int arr[], int n) {
        long val[] = new long[n];
        temp = new long[n];

        for (int i = 0; i < n; i++)
            val[i] = 1L * i * arr[i];

        return mergeSort(val, 0, n - 1);
    }
}
