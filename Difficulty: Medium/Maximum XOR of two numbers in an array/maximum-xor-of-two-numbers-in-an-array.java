// User function Template for Java
class Node {
    Node[] links = new Node[2];
   

    boolean containsKey(int node) {
        return links[node] != null;
    }

    Node get(int node) {
        return links[node];
    }

    void put(int n, Node node) {
        links[n] = node;
    }
}

class Trie {
   private static Node root;

    Trie() {
        root = new Node();
    }

    public static void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }

    public static int getMax(int num){
        Node node=root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit=(num >>i) & 1;
            if(node.containsKey(1-bit)){
                maxNum=maxNum | (1<<i);
                node=node.get(1-bit);
            }
            else {
                node=node.get(bit);
            }
        }
        return maxNum;
    }
 
}
class Solution {
    public int maxXor(int[] nums) {
    Trie trie=new Trie();

        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }

        int maxi=0;
        for(int i=1;i<nums.length;i++){
            maxi=Math.max(maxi,trie.getMax(nums[i]));
        }
        return maxi;
        
    }
}