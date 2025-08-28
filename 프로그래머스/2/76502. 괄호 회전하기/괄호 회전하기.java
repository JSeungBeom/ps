import java.util.*;

class Solution {
    
    static Deque<Character> stack;
    
    public int solution(String s) {
        int answer = 0;
        
        for(int rep = 0; rep < s.length() - 1; rep++) {
            
            stack = new ArrayDeque<>();
            
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                    stack.push(s.charAt(i));
                else if(s.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        stack.push('?'); break;
                    }
                }
                else if(s.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        stack.push('?'); break;
                    }
                }
                else if(s.charAt(i) == '}') {
                    if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else {
                        stack.push('?'); break;
                    }
                }
            }
            
            if(stack.isEmpty()) answer++;
            
            s += s.charAt(0);
            s = s.substring(1, s.length());
            
        }
        
        
        return answer;
    }
}