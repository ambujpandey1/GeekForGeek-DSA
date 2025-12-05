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
    
    // Function to serialize a tree and return the list
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr == null) {
                list.add(-1);      // null marker
                continue;
            }
            
            list.add(curr.data);
            q.offer(curr.left);
            q.offer(curr.right);
        }
        
        return list;
    }

    // Function to deserialize the list and reconstruct the tree
    public Node deSerialize(ArrayList<Integer> arr) {
        if(arr == null || arr.size() == 0) return null;
        
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        int i = 1;
        while(i < arr.size()) {
            Node parent = q.poll();
            
            // LEFT CHILD
            int leftVal = arr.get(i++);
            if(leftVal != -1) {
                parent.left = new Node(leftVal);
                q.offer(parent.left);
            }
            
            // RIGHT CHILD  
            if(i >= arr.size()) break;
            int rightVal = arr.get(i++);
            if(rightVal != -1) {
                parent.right = new Node(rightVal);
                q.offer(parent.right);
            }
        }
        
        return root;
    }
};
