import java.util.*;

class Solution {
    
    static Deque<Integer> dStack = new ArrayDeque<>();
    static Deque<Integer> pStack = new ArrayDeque<>();
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
      
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < deliveries[i]; j++) {
                dStack.push(i + 1);
            }
            
            for(int j = 0; j < pickups[i]; j++) {
                pStack.push(i + 1);
            }
        }
        
        
        while(!dStack.isEmpty() && !pStack.isEmpty()) {
            int idx1 = dStack.peek();
            int idx2 = pStack.peek();
            
            for(int i = 0; i < cap; i++) {
                if(!dStack.isEmpty()) dStack.pop();
                if(!pStack.isEmpty()) pStack.pop();                
            }
            
            answer += Math.max(idx1, idx2) * 2L;
        }
        System.out.println(answer);
                
        while(!dStack.isEmpty()) {
            int idx = dStack.peek();
            
            for(int i = 0; i < cap; i++) {
                dStack.pop();
                
                if(dStack.isEmpty()) break;
            }
            
            answer += idx * 2L;

        }
        
        while(!pStack.isEmpty()) {
            int idx = pStack.peek();
            
            for(int i = 0; i < cap; i++) {
                pStack.pop();
                
                if(pStack.isEmpty()) break;   
            }
            
            answer += idx * 2L;
        }
        
        return answer;
    }
}