// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        int n=pre_exp.length();
        int i=n-1;
        
        while(i>=0){
            char c=pre_exp.charAt(i);
            
            if(Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else{
                String t1=st.pop();
                String t2=st.pop();
                st.push(t1+t2+c);
            }
            i--;
        }
        
        return st.pop();
    }
}
