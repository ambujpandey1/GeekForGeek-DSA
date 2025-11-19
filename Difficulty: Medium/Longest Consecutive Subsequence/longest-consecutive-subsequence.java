class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int n=arr.length;
        
        if(n==0) return 0;
        Arrays.sort(arr);
        int lastsmaller=Integer.MIN_VALUE;;
        
        int cnt=0;
        int longest=1;
        for(int i=0;i<n;i++){
            if(arr[i]-1==lastsmaller){
                lastsmaller=arr[i];
                cnt+=1;
            }
            else if(arr[i]!=lastsmaller){
                cnt=1;
                lastsmaller=arr[i];
            }
            
            longest=Math.max(longest,cnt);
        }
        
        return longest;
    }
}