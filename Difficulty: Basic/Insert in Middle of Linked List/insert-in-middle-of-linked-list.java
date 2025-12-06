/*
Structure of node class is:
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public int getLength(Node head) {
       int n=0;
       while(head!=null){
           n++;
           head=head.next;
       } 
       
       return n;
        
    }
    public Node insertInMiddle(Node head, int x) {
  // If list is empty
        if (head == null) return new Node(x);

        int n = getLength(head);
        int mid = (n - 1) / 2;   // middle index (0-based)

        Node temp = head;
        // Move temp to the middle node (index mid)
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        // Insert new node AFTER temp
        Node newNode = new Node(x);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
        
    }
}