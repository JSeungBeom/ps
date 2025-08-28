import java.util.*;

class Solution {
    
    static HashSet<String> hs = new HashSet<>(); 
    static int number, turn;
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        char lastWord = words[0].charAt(words[0].length() - 1);
        hs.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            number = (i % n) + 1;
            turn = (i / n) + 1;
            
            char firstWord = words[i].charAt(0);
            
            if(hs.contains(words[i]) 
               || lastWord != firstWord 
               || words[i].length() == 1) {
                answer[0] = number;
                answer[1] = turn;
                
                return answer;
            }
            
            hs.add(words[i]);
            lastWord = words[i].charAt(words[i].length() - 1);
        }

        return new int[] {0, 0};
    }
}