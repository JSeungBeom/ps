import java.util.*;

class Solution {
    
    static HashSet<Integer> hs = new HashSet<>();
    
    public int solution(int[] elements) {
        for(int st = 0; st < elements.length; st++) {
            int sum = 0;
            
            for(int en = st; en < st + elements.length; en++) {
                sum += elements[(en % elements.length)];
                hs.add(sum);
            }
        }
        
        return hs.size();
    }
}