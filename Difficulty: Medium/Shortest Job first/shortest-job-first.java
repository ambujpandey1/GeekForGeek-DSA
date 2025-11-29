// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        int wt=0;
        int tt=0;
        int n=bt.length;
        Arrays.sort(bt);
        for(int i=0;i<n;i++){
            wt+=tt;
            tt+=bt[i];
        }
        
        return wt/n;
    }
}
