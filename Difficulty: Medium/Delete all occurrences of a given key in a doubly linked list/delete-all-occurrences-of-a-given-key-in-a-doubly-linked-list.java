// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head=head.next;
                    if(head!=null ) head.prev=null;
                }
            else{
            
            Node nextNode=temp.next;
            Node prevNode=temp.prev;
            
            if(nextNode!=null) nextNode.prev=prevNode;
            if(prevNode!=null) prevNode.next=nextNode;
            
            }
            }
            temp=temp.next;
        }
        
        return head;
        
    }
}