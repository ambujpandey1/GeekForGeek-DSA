/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        if(head==null || head.next==null) return head;
        
        Node curr=head;
        Node prvious=null;
        
        while(curr!=null){
            Node nextElemnt=curr.next;
            curr.next=prvious;
            curr.prev=nextElemnt;
            
            prvious=curr;
            curr=nextElemnt;
        }
        return prvious;
    }
}