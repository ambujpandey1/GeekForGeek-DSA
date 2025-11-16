class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
         int n = arr.length;

        long S = 0, P = 0;
        for (int r : arr) {
            S += r;          // sum of array
            P += (long) r * r;  // sum of squares
        }

        long S_expected = (long) n * (n + 1) / 2;  
        long P_expected = (long) n * (n + 1) * (2L * n + 1) / 6;

        long diff = S - S_expected;          // x - y
        long diff2 = P - P_expected;        // x^2 - y^2

        long sum = diff2 / diff;            // x + y

        long x = (diff + sum) / 2;          // repeating
        long y = x - diff;                  // missing

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) x);
        ans.add((int) y);

        return ans;
    }
}
