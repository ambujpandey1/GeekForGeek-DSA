class Solution {
    private static void insertAtBottom(int element ,Stack<Integer> st){
        if(st.isEmpty()) {
            st.push(element);
            return;
        }
        
        int top=st.pop();
        insertAtBottom(element,st);
        st.push(top);
    }
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty() || st.size()==1) return;
        
        int top=st.pop();
        reverseStack(st);
        insertAtBottom(top,st);
        
    }
}
