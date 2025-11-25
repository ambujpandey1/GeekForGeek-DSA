// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        int i=0;
        Stack<String> st=new Stack<>();
        int n=exp.length();
        
        while(i<n){
            char c=exp.charAt(i);
            
            if(Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else{
                String t2=st.pop();
                String t1=st.pop();
                
                st.push('('+t1+c+t2+')');
            }
            i++;
        }
        
        return st.peek();
    }
}
