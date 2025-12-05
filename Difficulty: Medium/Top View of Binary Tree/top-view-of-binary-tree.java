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

class Pair{
    Node node;
    int line;
    
    Pair(Node node, int line){
        this.node=node;
        this.line=line;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Pair> q=new LinkedList<Pair>();
        Map<Integer, Integer> map=new TreeMap<>(); // line-Node
        
        q.offer(new Pair(root,0));
        
        if(root==null) return ans;
        while(!q.isEmpty()){
           Pair p=q.poll();
           Node node=p.node;
           int line=p.line;
           
           if(map.get(line)==null) map.put(line,node.data);
           
           if(node.left!=null){
               q.offer(new Pair(node.left,line-1));
           }
           
           if(node.right!=null){
               q.offer(new Pair(node.right,line+1));
           }
            
        }
        
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}