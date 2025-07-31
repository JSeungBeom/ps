import java.util.*;

class Solution {
    
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
            HashSet<Character> hs = new HashSet<>();
            
            for(int j = 0; j < skill.length(); j++) {
                hs.add(skill.charAt(j));
            }
            
            int idx = 0;
            boolean isCompletable = true;
            
            for(int j = 0; j < skill_trees[i].length(); j++) {
                if(idx >= skill.length()) break;
                
                if(skill_trees[i].charAt(j) == skill.charAt(idx)) {
                    hs.remove(skill.charAt(idx));
                    idx++; 
                } else if(hs.contains(skill_trees[i].charAt(j))) {
                    isCompletable = false;
                    break;
                }    
            }
            
            if(isCompletable) answer++;
            
        }
        
        return answer;
    }
}