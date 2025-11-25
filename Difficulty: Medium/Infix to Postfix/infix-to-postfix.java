import java.util.*;

class Solution {
    static int prec(char c){
        if(c=='^') return 3;               // Highest, right-associative
        else if(c=='/' || c=='*') return 2;
        else if(c=='+' || c=='-') return 1;
        return -1;
    }
    
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // Operand
            if(Character.isLetterOrDigit(c)){
                res.append(c);
            }
            // Opening bracket
            else if(c == '('){
                st.push(c);
            }
            // Closing bracket
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res.append(st.pop());
                }
                st.pop(); // pop '('
            }
            // Operator
            else{
                while(!st.isEmpty() && st.peek() != '('){
                    char top = st.peek();
                    int pc = prec(c);
                    int pt = prec(top);
                    
                    if(pt > pc){
                        res.append(st.pop());
                    }
                    else if(pt == pc){
                        // '^' is right associative → do NOT pop when equal precedence
                        if(c == '^') break;
                        else res.append(st.pop());
                    }
                    else break;
                }
                
                st.push(c);  // <-- Correct place
            }
        }
        
        // Pop remaining operators
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        
        return res.toString();
    }
}
