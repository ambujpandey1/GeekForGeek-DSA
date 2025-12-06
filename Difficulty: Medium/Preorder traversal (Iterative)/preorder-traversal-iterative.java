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
    ArrayList<Integer> preOrder(Node root) {
        // code here
       ArrayList<Integer> ans=new ArrayList<>();
       Stack<Node> st=new Stack<>();
       st.push(root);
       
       while(!st.isEmpty()){
           root=st.pop();
           ans.add(root.data);
           if(root.right!=null) st.push(root.right);
           if(root.left!=null) st.push(root.left);
       }
       return ans;
    }
}