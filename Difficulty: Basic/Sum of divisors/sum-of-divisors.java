// User function Template for Java
class Solution {
    static long divSum(long n) {
        // code here
        long sum=0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum+=i;

                if (i != n / i) {
                   sum+=n/i;
                }
            }
        }
        
        return sum-n;
    }
}