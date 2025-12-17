

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int[] maxXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int m = queries.length;
        int n = nums.length;

        // offline queries: [mi, xi, index]
        ArrayList<int[]> offline = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            offline.add(new int[]{queries[i][1], queries[i][0], i});
        }

        offline.sort(Comparator.comparingInt(a -> a[0]));

        Trie trie = new Trie();
        int[] ans = new int[m];

        Arrays.fill(ans, -1);

        int ind = 0;

        for (int[] q : offline) {
            int mi = q[0];
            int xi = q[1];
            int idx = q[2];

            while (ind < n && nums[ind] <= mi) {
                trie.insert(nums[ind]);
                ind++;
            }

            if (ind > 0) {
                ans[idx] = trie.getMax(xi);
            }
        }

        return ans;
        
    }
}