import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
    
        while(true) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') sb.append('1');
                else answer[1]++;
            }
            
            
            s = Integer.toBinaryString(sb.length());
            
            System.out.println(s);
            
            answer[0]++;
            
            if(s.equals("1")) return answer;
        }
        
    }
}