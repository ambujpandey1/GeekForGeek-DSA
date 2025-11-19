// User function Template for Java

class Solution {

    public int findK(int matrix[][], int n, int m, int k) {
     
        

        int top=0;
        int bottom=n-1;
        int left=0;
        int right=m-1;
    while(top<=bottom && left<=right){
        for(int i=left;i<=right;i++){
          if(--k==0) return  matrix[top][i];
        }
        top++;
        for(int i=top;i<=bottom;i++){
         if(--k==0) return matrix[i][right];
        }
        right--;
       
       if(top<=bottom){
        for(int i=right;i>=left;i--){
         if(--k==0) return matrix[bottom][i];
        }

        bottom--;
       }

       if(left<=right){
        for(int i=bottom;i>=top;i--){
            if(--k==0) return matrix[i][left];
        }
       
       left++;
       }
    }

    return -1;
    }
}