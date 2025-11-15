class Solution {
    
static  ArrayList<Integer> printRow(int n){
        int ans=1;
        ArrayList<Integer> row=new ArrayList<>();
        row.add(ans);
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/(i);
            row.add(ans);
        }
        return row;
     }
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
       return printRow(n); 
    }
}