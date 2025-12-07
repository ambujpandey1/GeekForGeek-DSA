/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    private static Node tail(Node head){
        Node temp=head;
        while(temp.next!=null) temp=temp.next;
        
        return temp;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
       Node left=head;
       Node right=tail(head);
       
       ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
       
       while(left.data<right.data){
           int z=left.data+right.data;
           ArrayList<Integer> temp=new ArrayList<>();
           if(z==target){
              temp.add(left.data);
              temp.add(right.data);
              ans.add(temp);
              left=left.next;
              right=right.prev;
           }
           else if(z<target){
               left=left.next;
           }else{
               right=right.prev;
           }
       }
       
       return ans;
    }
}
