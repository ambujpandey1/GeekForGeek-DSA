// User function Template for Java

class Solution {
    static long primeProduct(int N) {
        long ans = 1;

        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                ans *= i;          // include the prime factor once
                while (N % i == 0) {
                    N /= i;       // remove all occurrences of i
                }
            }
        }

        // if N is still > 1, then it is a prime factor
        if (N > 1) {
            ans *= N;
        }

        return ans;
    }
}
