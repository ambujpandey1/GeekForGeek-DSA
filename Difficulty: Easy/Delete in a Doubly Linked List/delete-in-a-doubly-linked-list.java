/*
Structure of a Doubly LinkList
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node delPos(Node head, int x) {
     
        // If deleting the first node
        if (x == 1) {
            Node next = head.next;
            if (next != null) next.prev = null;
            return next;
        }

        Node temp = head;
        int cnt = 1;

        // Move temp to the x-th node
        while (temp != null && cnt < x) {
            temp = temp.next;
            cnt++;
        }

        // If x is out of bounds
        if (temp == null) return head;

        Node prev = temp.prev;
        Node next = temp.next;

        // Deleting last node
        if (next == null) {
            prev.next = null;
        } 
        // Deleting a middle node
        else {
            prev.next = next;
            next.prev = prev;
        }

        // Free temp links
        temp.next = null;
        temp.prev = null;

        return head;
        
    }
}