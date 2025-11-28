// User function Template for Java

class Solution {
    public static int subarrayLessEqualK(int[] nums, int k){
        int n=nums.length;
        int l=0;
        int cnt=0;
        Map<Integer,Integer> mp=new HashMap<>();

        for(int r=0;r<n;r++){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);

            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0) mp.remove(nums[l]);
                l++;
            }
            if(mp.size()<=k) cnt+=r-l+1;
        }

       return cnt;

    }
    static int exactlyK(int arr[], int k) {
         return subarrayLessEqualK(arr,k)-subarrayLessEqualK(arr,k-1);
        
    }
}
