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
class Tuple {
    Node node;
    int col;

    Tuple(Node n, int c) {
        node = n;
        col = c;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            Node node = t.node;
            int col = t.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.data);   // BFS order, NOT sorted

            if (node.left != null)
                q.offer(new Tuple(node.left, col - 1));

            if (node.right != null)
                q.offer(new Tuple(node.right, col + 1));
        }

        for (ArrayList<Integer> val : map.values()) {
            result.add(val);
        }

        return result;
    }
}