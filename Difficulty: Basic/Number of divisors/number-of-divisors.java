// User function Template for Java
class Solution {
    static int countDivisors(int n) {
        int cnt = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {

                // check i
                if (i % 3 == 0) {
                    cnt++;
                }

                int other = n / i;

                // check paired divisor
                if (other != i && other % 3 == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
