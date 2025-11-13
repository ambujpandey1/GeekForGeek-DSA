class Solution {

class DSU {
    Map<Integer, Integer> parent = new HashMap<>();

    // Function to find the ultimate parent of x
    public int find(int x) {
        // If x is not present, make it its own parent
        parent.putIfAbsent(x, x);

        // Path compression
        if (x != parent.get(x))
            parent.put(x, find(parent.get(x)));

        return parent.get(x);
    }

    // Function to connect two nodes
    public void union(int x, int y) {
        parent.put(find(x), find(y));
    }
}

    int maxRemove(int[][] stones, int n) {
        // Code here
         DSU dsu = new DSU();

        // Connect each stone's row and column (offset column by 10001)
        for (int[] stone : stones) {
            dsu.union(stone[0], stone[1] + 10001);
        }

        Set<Integer> components = new HashSet<>();

        // Count unique connected components
        for (int[] stone : stones) {
            components.add(dsu.find(stone[0]));
        }

        // Max stones removed = total stones - number of components
        return stones.length - components.size();
        
    }
};
