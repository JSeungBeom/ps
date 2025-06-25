import java.util.*;

class Solution {
    
    static int cnt;
    static String cur;
    
    public int solution(int n) {        
        cur = Integer.toBinaryString(n);
        
        for(int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) == '1') cnt++;
        }
        
        for(int i = n + 1; i <= 1000000; i++) {
            cur = Integer.toBinaryString(i);
            
            int ccnt = 0;
            
            for(int j = 0; j < cur.length(); j++) {
                if(cur.charAt(j) == '1') ccnt++;
            }
            
            if(cnt == ccnt) return i;
        }
        
        return 0;
    }
}