// User function Template for Java
class Solution {
    static  long countAtMost(long X, int[] A) {
        if (X < 0) return 0;

        long count = 0, sum = 0;
        int left = 0;

        for (int right = 0; right < A.length; right++) {
            sum += A[right];

            while (sum > X) {
                sum -= A[left];
                left++;
            }

            count += (right - left + 1);
        }
        return count;
    }
    long countSubarray(int N, int A[], long L, long R) {
        // codae here
        // long cnt = 0;

        // for (int i = 0; i < N; i++) {
        //     long sum = 0;

        //     for (int j = i; j < N; j++) {
        //         sum += A[j];

        //         if (sum >= L && sum <= R) {
        //             cnt++;
        //         }
        //     }
        // }

        // return cnt;
        
        return countAtMost(R, A) - countAtMost(L - 1, A);
    }
}