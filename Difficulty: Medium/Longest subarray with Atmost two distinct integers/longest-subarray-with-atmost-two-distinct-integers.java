class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n=arr.length;
        int maxlen=0;
        int l=0;
        int r=0;
        Map<Integer,Integer> mp=new HashMap<>();
        
        while(r<n){
           mp.put(arr[r],mp.getOrDefault(arr[r],0)+1);
           
           while(mp.size()>2){
             mp.put(arr[l], mp.get(arr[l])-1);  
             if(mp.get(arr[l])==0) mp.remove(arr[l]);
             l++;
           }
           
           if(mp.size()<=2){
               maxlen=Math.max(maxlen,r-l+1);
           }
           r++;
        }
        return maxlen;
    }
}