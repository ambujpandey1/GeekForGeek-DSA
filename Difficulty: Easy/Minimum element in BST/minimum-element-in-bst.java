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
    public int minValue(Node root) {
        // code here
      Node temp=root;
      
      while(temp.left!=null){
          temp=temp.left;
      }
      return temp.data;
    }
}