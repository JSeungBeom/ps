import java.util.*;

class Solution {
    public int solution(int[] citations) { 
        int answer = 0;
        
        Arrays.sort(citations); 
        
        int n = citations.length;
        
        for(int i = n - 1; i >= 0; i--) {
            int comp = n - i;
            
            if(comp <= citations[i]) {
                answer = comp;        
            }
        }
        
        return answer;
    }
}