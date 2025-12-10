class Solution {
    public int kthElement(int nums1[], int nums2[], int kth) {
         int[] merged=new int[nums1.length+nums2.length];
       int i=0,j=0,k=0;

       while(i<nums1.length && j<nums2.length){
          if(nums1[i]<nums2[j]){
            merged[k++]=nums1[i++];
          }else{
            merged[k++]=nums2[j++];
          }

       }

       while(i<nums1.length){
        merged[k++]=nums1[i++];
       }

         while(j<nums2.length){
        merged[k++]=nums2[j++];
       }
        
        int n=merged.length;
        return merged[kth-1];
        
    }
}