/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
         // Morris Traversal
      ArrayList<Integer> inorder=new ArrayList<>();
       Node curr= root;
       while(curr!=null){
        if(curr.left==null){
            inorder.add(curr.data);
            curr=curr.right;
        }
        else{
            Node prev=curr.left;
            while(prev.right!=null &&prev.right!=curr){
               prev=prev.right;
            }
            if(prev.right==null){
                prev.right=curr;
                curr=curr.left;
            }else{
                prev.right=null;
                inorder.add(curr.data);
               curr= curr.right;
            }
        }
       }
    return inorder;
    }
}