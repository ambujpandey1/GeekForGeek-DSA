/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int findl(Node head){
        Map<Node ,Integer> map=new HashMap<>();
        Node temp=head;
        int timer=1;
        
        while(temp!=null){
            if(map.containsKey(temp)){
                int value=map.get(temp);
                return timer-value;
            }
            map.put(temp,timer);
            timer++;
            temp=temp.next;
        }
        
        return 0;
    }
    public int lengthOfLoop(Node head) {
        // return findl(head);// brute force
        
        
        
    }
}