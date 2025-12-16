// User function Template for Java

class Solution {
    // Brute force;
    public static int findXOR1(int l, int r) {
        int ans=l;
        for(int i=l+1;i<=r;i++){
            ans=ans^i;
        }
        return ans;
    }
    
    static int findXorTilN(int n){
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
         return n;
    }
    public static int findXOR(int l, int r) {
        return findXorTilN(l-1) ^ findXorTilN(r);
    }
}