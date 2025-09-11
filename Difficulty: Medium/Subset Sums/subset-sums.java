// User function Template for Java//User function Template for Java
class Solution {
    void findSubsetSum(int idx, int sum,int[] arr, ArrayList<Integer> ans){
       if(idx==arr.length){
           ans.add(sum);
           return;
       } 
       // Pick the element
       findSubsetSum(idx+1,sum+arr[idx],arr,ans);
       // Not Pick the element
       findSubsetSum(idx+1,sum,arr,ans);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        findSubsetSum(0,0,arr,ans);
        Collections.sort(ans);
        return ans;
        
    }
}