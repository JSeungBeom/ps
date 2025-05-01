import java.util.*;

class Solution {
    static Set<String> set = new HashSet<>();
    static Map<String, Integer> ans = new HashMap<>();
    static int mn = Integer.MAX_VALUE;
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        int st = 0;

        for(int en = 0; en < gems.length; en++){
            ans.put(gems[en], ans.getOrDefault(gems[en], 0) + 1);

            while(st <= en && ans.size() == set.size()) {                
                if(en - st + 1 < mn) {
                    mn = en - st + 1;
                    answer[0] = st + 1;
                    answer[1] = en + 1;
                }
                ans.put(gems[st], ans.get(gems[st]) - 1);
                
                if(ans.get(gems[st]) == 0)
                    ans.remove(gems[st]);
                st++;
            }     

        }
        
        if(answer[0] == 0 && answer[1] == 0){
            answer[0] = 1;
            answer[1] = gems.length;
        }
        
        return answer;
    }
}