// User function Template for Java

class Solution {
    static int characterReplacement(String s, int k) {
        // code here
         int[] freq=new int[26];
        int l=0;
        int maxl=0;
        int maxCount=0;
        int n=s.length();

        for(int r=0;r<n;r++){
          freq[s.charAt(r)-'A']++;
          maxCount=Math.max(maxCount,freq[s.charAt(r)-'A']);

          if((r-l+1)-maxCount>k){
            freq[s.charAt(l)-'A']--;
            l++;
          }

          maxl=Math.max(maxl,(r-l+1));
        }

        return maxl;
    }
}
