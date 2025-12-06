/*
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
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
       Node newNode = new Node(x);
        Node temp = head;
        
        // Move to the p-th node
        for (int i = 0; i < p; i++) {
            temp = temp.next;
        }
        
        // Now insert newNode after temp
        Node nextNode = temp.next;
        
        temp.next = newNode;
        newNode.prev = temp;
        
        newNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = newNode;
        }
        
        return head;
    }
}