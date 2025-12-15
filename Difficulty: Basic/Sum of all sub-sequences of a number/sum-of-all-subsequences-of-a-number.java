// User function Template for Java

class Solution {
    int subsequenceSum(String s) {
        int sum=0;
        int n=s.length();
        for(int i=0;i<n;i++) sum+=s.charAt(i)-'0';
        
        int power=1<<(n-1); // eac
        
        return sum*power;
    }
}