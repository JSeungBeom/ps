import java.util.*;

class Solution {
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            int numOfZeros = Long.numberOfTrailingZeros(~numbers[i]);
            
            if(numOfZeros == 0) answer[i] = numbers[i] + 1L;
            else answer[i] = numbers[i] + (1L << (numOfZeros - 1));
        }
        
        return answer;
    }
}