import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int st = (int) begin;
        int en = (int) end;
        
        int[] answer = new int[en - st + 1];
        Arrays.fill(answer, 1);
        
        for(int i = st; i <= en; i++) {
            answer[i - st] = solve(i);
        }
        
        if(st == 1) answer[0] = 0;
        
        return answer;
    }
    
    static int solve(int num) {
        int max = 1;
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                max = i;
            
                if(num / i <= 10000000)
                return num / i;
            }
        }
        
        return max;
    }
}