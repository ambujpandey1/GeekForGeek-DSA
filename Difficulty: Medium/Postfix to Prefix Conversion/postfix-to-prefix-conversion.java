// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int i=0;
        int n=post_exp.length();
        Stack<String> st=new Stack<>();
        while(i<n){
            char c=post_exp.charAt(i);
            
            if(Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else{
                String t1=st.pop();
                String t2=st.pop();
                
                st.push(c+t2+t1);
            }
            i++;
        }
        
        return st.pop();
    }
}
