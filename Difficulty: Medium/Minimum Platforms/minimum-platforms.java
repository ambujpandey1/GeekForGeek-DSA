class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform=1;
        int res=1;
        
        int i=1;
        int j=0;
        
        int n=arr.length;
        
        while(i< n && j<n){
            if(arr[i]<=dep[j]){
                platform++;
                i++;
            }else{
                platform--;
                j++;
            }
            
            res=Math.max(res,platform);
        }
        
        return res;
    }
}
