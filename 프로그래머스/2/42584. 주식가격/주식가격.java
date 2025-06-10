import java.util.*;

class Solution {
    
    static Deque<int[]> stack = new ArrayDeque<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        stack.push(new int[] {0, prices[0]});
        
        for(int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] cur = stack.poll();
                
                answer[cur[0]] = i - cur[0];
            }
            
            stack.push(new int[] {i, prices[i]});
        }
        
        while(!stack.isEmpty()) {
            int[] cur = stack.poll();
            
            answer[cur[0]] = prices.length - cur[0] - 1;
        }
        
        return answer;
    }
}