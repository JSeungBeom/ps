import java.util.*;

class Solution {

    static HashMap<String, Integer> dictionary = new HashMap<>();
    static boolean[] visit;
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String msg) {        
        for(int i = 0; i < 26; i++) {
            dictionary.put(Character.toString(i + 'A'), i + 1);
        }
        
        visit = new boolean[msg.length() + 1];
        
        int added = 27;
        String tmp = "";
                
        for(int i = 0; i < msg.length(); i++) {
            if(visit[i]) continue;
            
            tmp = Character.toString(msg.charAt(i));
            visit[i] = true;
            for(int j = i + 1; j < msg.length(); j++) {
                tmp += msg.charAt(j);
                
                if(!dictionary.containsKey(tmp)) {
                    dictionary.put(tmp, added++);
                    answer.add(dictionary.get(tmp.substring(0, tmp.length() - 1)));
                    break;
                }
                
                visit[j] = true;
            }
            
        }
        
        answer.add(dictionary.get(tmp));
        
                
        return answer.stream().mapToInt(i -> i).toArray();
    }
}