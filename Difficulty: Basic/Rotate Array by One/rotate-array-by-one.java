// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
         int n = arr.length;
        if (n <= 1) return;

        int last = arr[n - 1];   // store last element

        // shift elements right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = last;   // put last at first position
        
    }
}