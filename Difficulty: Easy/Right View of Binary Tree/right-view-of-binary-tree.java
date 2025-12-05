/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    void preorder(Node root, int level,ArrayList<Integer> ans ){
        if(root==null) return ;

        if(level==ans.size()) ans.add(root.data);
        preorder(root.right,level+1,ans);
        preorder(root.left,level+1,ans);
    }
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        preorder(root,0,ans);
        return ans;
    }
}