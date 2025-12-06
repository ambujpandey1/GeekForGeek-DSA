/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
     public Node inorderSuccessor(Node root, int x) {
       Node succwssiosor=null;
       
       while(root!=null){
           if(x>=root.data) root=root.right;
           else{
             succwssiosor=root;
             root=root.left;
           }
       }
       return succwssiosor;
    }
    
     public Node inorderPredecessor (Node root, int x) {
       Node predecessor =null;
       
       while(root!=null){
           if(x>root.data) 
           {
            predecessor =root;
               root=root.right;
           }
           else{
            
             root=root.left;
           }
       }
       return predecessor ;
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        
        ArrayList<Node> ans=new ArrayList<>();
        ans.add(inorderPredecessor(root,key));
        ans.add(inorderSuccessor(root,key));
        
        return ans;
        
    }
}