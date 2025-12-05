/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
            // Morris Traversal
      ArrayList<Integer> preorder=new ArrayList<>();
       Node curr= root;
       while(curr!=null){
        if(curr.left==null){
            preorder.add(curr.data);
            curr=curr.right;
        }
        else{
            Node prev=curr.left;
            while(prev.right!=null &&prev.right!=curr){
               prev=prev.right;
            }
            if(prev.right==null){
                prev.right=curr;
                preorder.add(curr.data);
                curr=curr.left;
            }else{
                prev.right=null;
                
               curr= curr.right;
            }
        }
       }
    return preorder;
    }
}