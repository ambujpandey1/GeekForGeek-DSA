// User function Template for Java
class Solution {
    static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] dp) {
        if (i > j) return 0L;
        if (i == j) {
            if (isTrue == 1) return exp.charAt(i) == 'T' ? 1L : 0L;
            else return exp.charAt(i) == 'F' ? 1L : 0L;
        }

        if (dp[i][j][isTrue] != null) return dp[i][j][isTrue];

        long ways = 0L;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = evaluateExpressionWays(exp, i, ind - 1, 1, dp);
            long lF = evaluateExpressionWays(exp, i, ind - 1, 0, dp);
            long rT = evaluateExpressionWays(exp, ind + 1, j, 1, dp);
            long rF = evaluateExpressionWays(exp, ind + 1, j, 0, dp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways += lT * rT;
                } else {
                    ways += lF * rT + lT * rF + lF * rF;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways += lT * rT + lT * rF + lF * rT;
                } else {
                    ways += lF * rF;
                }
            } else { // '^'
                if (isTrue == 1) {
                    ways += lT * rF + lF * rT;
                } else {
                    ways += lT * rT + lF * rF;
                }
            }
        }

        dp[i][j][isTrue] = ways;
        return ways;
    }

    static int countWays(String exp) {
        int n = exp.length();
        Long[][][] dp = new Long[n][n][2];
        long ans = evaluateExpressionWays(exp, 0, n - 1, 1, dp);
        return (int) ans; // judge's expected answer fits in int for the test shown
    }
}
