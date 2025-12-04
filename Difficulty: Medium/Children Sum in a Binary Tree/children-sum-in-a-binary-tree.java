/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
  // base case: empty tree or leaf node
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int leftVal = (root.left != null) ? root.left.data : 0;
        int rightVal = (root.right != null) ? root.right.data : 0;

        // check current node + recursive check on children
        return (root.data == leftVal + rightVal) &&
               isSumProperty(root.left) &&
               isSumProperty(root.right);
    }
}