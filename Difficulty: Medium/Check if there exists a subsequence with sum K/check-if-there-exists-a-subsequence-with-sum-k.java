import java.util.Arrays;

class Solution {
    static boolean f(int idx, int sum, int N, int[] arr, int K, int[][] dp) {

        // Found valid subsequence
        if (sum == K) return true;

        // End of array
        if (idx == N) return false;

        // Memoization check
        if (dp[idx][sum] != -1)
            return dp[idx][sum] == 1;

        // Not pick
        boolean notPick = f(idx + 1, sum, N, arr, K, dp);

        // Pick
        boolean pick = false;
        if (sum + arr[idx] <= K) {
            pick = f(idx + 1, sum + arr[idx], N, arr, K, dp);
        }

        // Store result
        dp[idx][sum] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {

        int[][] dp = new int[N][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, N, arr, K, dp);
    }
}
