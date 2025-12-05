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
    private static Node bfsMapParents(Node root, HashMap<Node,Node> map,int target)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        Node res=null;
        
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.data==target) res=node;
            
            if(node.left!=null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right,node);
                q.offer(node.right);
            }
        }
        return res;
    }
    
    private static int findMaxDistance(HashMap<Node,Node> map,Node target){
        Queue<Node> q=new LinkedList<>();
        
        q.offer(target);
        
        Map<Node,Boolean> vis=new HashMap<>();
        vis.put(target,true);
        int maxi=0;
        while(!q.isEmpty()){
            int size=q.size();
           
            int fl=0;
            for(int i=0;i<size;i++){
                
                 Node node=q.poll();
            
            if(node.left!=null && vis.get(node.left)==null){
                fl=1;
                vis.put(node.left,true);
                q.offer(node.left);
            }
            
            if(node.right!=null && vis.get(node.right)==null){
                fl=1;
                vis.put(node.right,true);
                q.offer(node.right);
            }
            
            if(map.get(node)!=null && vis.get(map.get(node))==null){
                fl=1;
                vis.put(map.get(node),true);
                q.offer(map.get(node));
            }
            }
            if(fl==1) maxi++;
        }
        
        return maxi;
        
        
        
    }
    public int minTime(Node root, int target) {
       HashMap<Node,Node> map=new HashMap<>();
       Node ta=bfsMapParents(root,map,target);
       
       int maxi=findMaxDistance(map,ta);
       return maxi;
        
    }
}