import java.util.*;

class Solution {
        
    public String solution(String p) {
        String answer = "";
        
        return divideParentheses(p);
    }
    
    static String divideParentheses(String s) {
        
        if(s.isEmpty()) return "";  
        
        String u = "";
        String v = "";
        
        int num1 = 0;
        int num2 = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') num1++;
            if(s.charAt(i) == ')') num2++;
            
            if(num1 == num2) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1, s.length());
                break;
            }
        }
        
        if(checkRightParentheses(u)) return u + divideParentheses(v);
        else {
            StringBuilder sb = new StringBuilder();    
            
            for(int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                sb.append(c == ')' ? '(' : ')');
            }
            
            return "(" + divideParentheses(v) + ")" + sb.toString();
        }       
    }
    
    static boolean checkRightParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push('(');
            else if(stack.isEmpty()){
                return false;        
            }
            else if(s.charAt(i) == ')')
                stack.pop();
        }
        
        if(stack.isEmpty()) return true;
        
        return false;
    }
}