/*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        Node current=head;
        
        while(current !=null && current.next!=null){
            Node nextDistinct=current.next;
            
            while(nextDistinct!=null&& nextDistinct.data==current.data){
                nextDistinct=nextDistinct.next;
            }
            
            current.next=nextDistinct;
            if(nextDistinct!=null){
                nextDistinct.prev=current;
            }
            current=current.next;
        }
        return head;
    }
}