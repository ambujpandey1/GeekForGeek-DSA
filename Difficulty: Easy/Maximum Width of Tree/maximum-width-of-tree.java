/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxWidth(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();      // number of nodes at current level
            ans = Math.max(ans, size);

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null)  q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return ans;
    }
}
