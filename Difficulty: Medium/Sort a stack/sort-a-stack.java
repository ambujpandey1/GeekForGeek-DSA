class Solution {
    private static void sort(Stack<Integer> st){
        if(st.isEmpty() || st.size()==1) return;
        
        int top=st.pop();
        sort(st);
        insert(top,st);
       
    }
    
    private static void insert(int element, Stack<Integer> st){
        if(st.isEmpty() || st.peek()<element){
            st.push(element);
            return;
        }
        
        int top=st.pop();
        insert(element,st);
        st.push(top);
       
    }
    public void sortStack(Stack<Integer> st) {
       sort(st);
        
    }
}