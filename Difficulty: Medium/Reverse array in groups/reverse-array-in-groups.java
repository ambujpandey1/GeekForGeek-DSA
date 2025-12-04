class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(k>n) k=n;
        for(int i=0;i<n;i=i+k){
            int left=i;
            int right=Math.min(i+k-1,n-1);
            
            while(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
    }
}