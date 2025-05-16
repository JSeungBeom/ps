import java.util.*;

class Solution {
    
    static Deque<int[]> stack = new ArrayDeque<>();
    
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < numbers[i]) {
                answer[stack.poll()[0]] = numbers[i];
            }
            
            stack.push(new int[] {i, numbers[i]});
        }
        
        while(!stack.isEmpty()) {
            answer[stack.poll()[0]] = -1;
        }
        
        return answer;
    }
}