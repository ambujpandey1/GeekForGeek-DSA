import java.util.*;

class Solution {

    static class Job {
        int dead;
        int profit;
        Job(int d, int p) {
            dead = d;
            profit = p;
        }
    }

    int find(int parent[], int s) {
        if (parent[s] == s) return s;
        return parent[s] = find(parent, parent[s]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;
        Job[] arr = new Job[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Job(deadline[i], profit[i]);
        }

        // Sort jobs by profit DESC
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxi = 0;
        for (Job j : arr) maxi = Math.max(maxi, j.dead);

        // DSU parent array
        int[] parent = new int[maxi + 1];
        for (int i = 0; i <= maxi; i++) parent[i] = i;

        int countJobs = 0;
        int jobProfit = 0;

        for (int i = 0; i < n; i++) {

            int available = find(parent, arr[i].dead);

            // If a free slot exists
            if (available > 0) {
                countJobs++;
                jobProfit += arr[i].profit;

                // Mark this slot as filled → union with previous slot
                parent[available] = find(parent, available - 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(countJobs);
        res.add(jobProfit);

        return res;
    }
}
