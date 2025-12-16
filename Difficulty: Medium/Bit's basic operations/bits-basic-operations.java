class Solution {

    // 1. XOR of two numbers
    public int XOR(int n, int m) {
        return n ^ m;
    }

    // 2. Check if ath bit (1-indexed) of b is set
    public int check(int a, int b) {
        // shift (a-1) times because it's 1-indexed
        return ((b >> (a - 1)) & 1);
    }

    // 3. Set the cth bit (0-indexed) of d if not already set
    public int setBit(int c, int d) {
        return (d | (1 << c));
    }
}
