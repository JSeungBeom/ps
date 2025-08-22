import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int cur = storey % 10;
            storey /= 10;
            
            if(cur == 5) {
                if((storey + 1) % 10 > 5 || (storey + 1) % 10 == 0) {
                    answer += (10 - cur);
                    storey += 1;
                } else {
                    answer += cur;
                }
            }
            else if(cur > 5) {
                answer += (10 - cur);
                storey += 1;
            } 
            else {
                answer += cur;
            }
        }
        
        return answer;
    }
}