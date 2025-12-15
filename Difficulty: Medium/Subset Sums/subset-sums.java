// User function Template for Java//User function Template for Java
class Solution {
    static void f(int idx, int currSum,int[] arr,ArrayList<Integer> sums){
        if(idx==arr.length){
            sums.add(currSum);
            return ;
        }
        
        f(idx+1,currSum+arr[idx],arr,sums);
        
        f(idx+1,currSum,arr,sums);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> sums=new ArrayList<>();
        f(0,0,arr,sums);
        Collections.sort(sums);
        return sums;
        
    }
}