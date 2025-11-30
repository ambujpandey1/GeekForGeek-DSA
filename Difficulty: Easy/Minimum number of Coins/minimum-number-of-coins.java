class Solution {
    public int findMin(int n) {
        // code here
        int[] coins={ 1, 2, 5, 10 };
        int l=coins.length;
        int count=0;
        
        for(int i=l-1;i>=0;i--){
            while(n>=coins[i]){
               n-=coins[i];
               count++;
            } 
        }
        return count;
    }
}
