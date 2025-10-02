// User function Template for Java

class Solution {
    int maxCoclate(int i, int j1,int j2,int n, int m,int mat[][],int[][][] dp){
        
        if(j1<0 || j2<0 || j1>=m || j2>=m) return (int) Math.pow(-10,9);
        if(i==n-1){
            if(j1==j2) return mat[i][j1];
            else return mat[i][j1]+mat[i][j2];
        }
        
        int maxi=Integer.MIN_VALUE;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        for(int di=-1;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                int ans;
                if(j1==j2){
                    ans=mat[i][j1]+maxCoclate(i+1,j1+di,j2+dj,n,m,mat,dp);
                }
                else{
                    ans=mat[i][j1]+mat[i][j2]+maxCoclate(i+1,j1+di,j2+dj,n,m,mat,dp);
                }
                maxi=Math.max(maxi,ans);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int[][][] dp=new int[n][m][m];
        for(int[][] r1:dp){
            for(int[] r:r1){
            Arrays.fill(r,-1);
            }
        }
        return maxCoclate(0,0,m-1,n,m,grid,dp);
    }
}