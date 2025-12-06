/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
       Node succwssiosor=null;
       
       while(root!=null){
           if(x.data>=root.data) root=root.right;
           else{
             succwssiosor=root;
             root=root.left;
           }
       }
       return succwssiosor==null?-1:succwssiosor.data;
    }
}