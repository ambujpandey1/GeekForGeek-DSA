// User function Template for Java

/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root) {
      ArrayList<Integer> ans= new ArrayList<>();
      Stack<Node> st=new Stack<>();
      Node node=root;
      
      while(true){
          if(node!=null){
              st.push(node);
              node=node.left;
          }
          else{
              if(st.isEmpty()) break;
              node=st.pop();
              ans.add(node.data);
              node=node.right;
          }
      }
      
      return ans;
    }
}