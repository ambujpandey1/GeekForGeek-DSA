/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
       int n=0;
       while(head!=null){
           n++;
           head=head.next;
       } 
       
       return n;
        
    }
}