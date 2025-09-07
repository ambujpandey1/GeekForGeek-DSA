class Solution {
      static long m=1_000_000_007;
       static long findPow(long a, long b){
            if(b==0) return 1;
            long half=findPow(a,b/2);
            long res=(half*half) % m;

            if(b%2==1)
            {
                res=(res*a)%m;
            }
            return res;
        }
    public static int countGoodNumbers(long n) {
        // code here
         return (int)((findPow(5,(n+1)/2)*findPow(4,n/2))%m);
    }
}
