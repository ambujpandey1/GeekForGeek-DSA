class Sol {
    
    private static int countOnes(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int firstOne = -1;
        
        // Binary search for first occurrence of 1
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == 1) {
                firstOne = mid;
                r = mid - 1;  // look for earlier 1
            } else {
                l = mid + 1;  // skip 0's
            }
        }
        
        if (firstOne == -1) return 0; // no 1s found
        return arr.length - firstOne;
    }
    
    public static int maxOnes(int Mat[][], int N, int M) {
        int maxOnes = 0;
        int rowIndex = -1;
        
        for (int i = 0; i < N; i++) {
            int ones = countOnes(Mat[i]);
            if (ones > maxOnes) {
                maxOnes = ones;
                rowIndex = i;
            }
        }
        return rowIndex;
    }
}
