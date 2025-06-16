import java.util.*;

class Solution {
    public String solution(String s) {
        String[] num = s.split(" ");
        
        int mx = Integer.parseInt(num[0]);
        int mn = Integer.parseInt(num[0]);
        
        for(int i = 1; i < num.length; i++) {
            mx = Math.max(mx, Integer.parseInt(num[i]));
            mn = Math.min(mn, Integer.parseInt(num[i]));
        }
        
        return mn + " " + mx;
    }
}