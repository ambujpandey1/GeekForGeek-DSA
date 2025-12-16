class Node {
    Node[] links = new Node[26];
   

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

   
}


class Solution {
    public static int countSubs(String s) {
       int cnt=0;
       Node root=new Node();
       int n=s.length();
       for(int i=0;i<n;i++){
           Node node=root;
           for(int j=i;j<n;j++){
               if(!node.containsKey(s.charAt(j))){
                   node.put(s.charAt(j),new Node());
                   cnt++;
               }
               node=node.get(s.charAt(j));
           }
           
       }
        return cnt;
    }
}