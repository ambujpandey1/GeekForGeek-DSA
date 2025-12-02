/* A Binary Tree node
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

class Solution {

    void countPaths(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfs(root, 1, map);  // count nodes, root = length 1

        for (int len : map.keySet()) {
            System.out.print(len + " " + map.get(len) + " $");
        }
    }

    void dfs(Node node, int length, TreeMap<Integer, Integer> map) {
        if (node == null) return;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            map.put( length,map.getOrDefault(length, 0) + 1);
            return;
        }

        dfs(node.left, length + 1, map);
        dfs(node.right, length + 1, map);
    }
}
