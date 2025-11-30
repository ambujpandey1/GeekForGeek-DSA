class Solution {

 class Meet{
     int st;
     int et;
     Meet(int s, int e ){
         this.st=s;
         this.et=e;
     }
 }
 

    public int maxMeetings(int start[], int end[]) {
        int n=start.length;
       
       Meet[] arr=new Meet[n];
       
       for(int i=0;i<n;i++){
           arr[i]=new Meet(start[i],end[i]);
       }
       
       // compartor 
       Arrays.sort(arr,(a,b)->a.et-b.et);
       int res=1;
       int lastend=arr[0].et;
       for(int i=1;i<n;i++){
           if(arr[i].st>lastend){
             res++;
             lastend=arr[i].et;
           }
       }
       
       return res;
    }
}
