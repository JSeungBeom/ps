import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long dist = 1L * d * d;
        
        for(int x = 0; x <= d; x += k) {
            long xMax = dist - (1L * x * x);
            
            long yMax = (long)Math.sqrt(xMax);
            
            answer += (yMax / k) + 1;
        }
        
        return answer;
    }
}