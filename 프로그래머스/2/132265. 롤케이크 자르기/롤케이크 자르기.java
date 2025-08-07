import java.util.*;

class Solution {
    
    static int[] num = new int[10005];
    
    static HashSet<Integer> hs1 = new HashSet<>();
    static HashSet<Integer> hs2 = new HashSet<>();
   
    public int solution(int[] topping) {
        int answer = 0;
        
        int n = topping.length;
        
        for(int i = 0; i < n; i++) {
            hs2.add(topping[i]);
            num[topping[i]]++;
        }
        
        for(int i = 0; i < n; i++) {            
            num[topping[i]]--;
            hs1.add(topping[i]);
            
            if(num[topping[i]] == 0)
                hs2.remove(topping[i]);
            
            if(hs1.size() == hs2.size()) answer++;

        }
        
        
        return answer;
    }
}