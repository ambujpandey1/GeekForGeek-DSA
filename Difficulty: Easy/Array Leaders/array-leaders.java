class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
       
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
         int max=arr[n-1];
        
        ans.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=max){
                ans.add(arr[i]);
                max=arr[i];
            }
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
