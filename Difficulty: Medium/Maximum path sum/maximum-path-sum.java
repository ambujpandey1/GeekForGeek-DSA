/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
     int  maxSum=Integer.MIN_VALUE;
    int dfs(Node node){
        if(node==null) return 0;

        int left=Math.max(0,dfs(node.left));
        int right=Math.max(0,dfs(node.right));

        maxSum=Math.max(maxSum,left+right+node.data);
        return Math.max(left,right)+node.data;
    }
    int findMaxSum(Node root) {
        // code here
        //  maxSum=Integer.MIN_VALUE;
         dfs(root);
        return maxSum;
    }
}