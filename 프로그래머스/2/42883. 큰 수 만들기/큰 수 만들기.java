import java.util.*;

class Solution {
    
    static Deque<Character> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String number, int k) {
        String answer = "";
                
        for(int i = 0; i < number.length(); i++) {
            if(k != 0) {
                while(!stack.isEmpty() 
                      && number.charAt(i) > stack.peek()) {
                    stack.pop();
                    k--;
                    if(k == 0) {
                        break;
                    }
                }
            }
            
            stack.push(number.charAt(i));
        }
        
        for(int i = 0; i < k; i++) {
            stack.pop();
        }

        while(!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        
        
        return sb.reverse().toString();
    }
}