// Definition for the binary tree node
// class Node {
//     int data;
//     Node left, right;

//     public Node(int d) {
//         data = d;
//         left = right = null;
//     }
// }

// Helper class to store information about each subtree
class NodeValue {
    int minNode, maxNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

class Solution {

    // Helper function to compute largest BST
    private static NodeValue largestBstSubtreeHelper(Node root) {

        // Base case: empty tree is a BST of size 0
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // Recurse on left and right subtrees
        NodeValue left = largestBstSubtreeHelper(root.left);
        NodeValue right = largestBstSubtreeHelper(root.right);

        // Check if the current node maintains BST property
        if (left.maxNode < root.data && root.data < right.minNode) {
            // It’s a BST → return updated values
            return new NodeValue(
                Math.min(root.data, left.minNode),
                Math.max(root.data, right.maxNode),
                left.maxSize + right.maxSize + 1
            );
        }

        // If not a BST, return invalid range and max size so far
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.maxSize, right.maxSize)
        );
    }

    // Main function
    static int largestBst(Node root) {
        return largestBstSubtreeHelper(root).maxSize;
    }
}
