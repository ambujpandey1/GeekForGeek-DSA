// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tree {
    ArrayList<Integer> postOrder(Node root) {
         ArrayList<Integer> ans=new ArrayList<>();
         Stack<Node> st1=new Stack<>();
         Stack<Node> st2=new Stack<>();
         st1.push(root);
         
         if(root==null) return ans;
         while(!st1.isEmpty()){
             root=st1.pop();
             st2.push(root);
             if(root.left!=null) st1.push(root.left);
             if(root.right!=null) st1.push(root.right);
         }
        
        while(!st2.isEmpty()) ans.add(st2.pop().data);
        
        return ans;
    }
}