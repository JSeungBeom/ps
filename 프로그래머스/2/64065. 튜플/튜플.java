import java.util.*;

class Solution {
    
    static HashMap<Integer, Integer> hm = new HashMap<>();
    
    public int[] solution(String s) {        
        int[] answer;
            
        String[] tuples = s.split("},");
            
        int max = 0;
        
        for(int i = 0; i < tuples.length; i++) {
            tuples[i] = tuples[i].replace("{", "");
            tuples[i] = tuples[i].replace("}", "");
            
            String[] numbers = tuples[i].split(",");
            max = Math.max(max, numbers.length);
            
            for(int j = 0; j < numbers.length; j++) {
                int number = Integer.parseInt(numbers[j]);
                
                hm.put(number, hm.getOrDefault(number, 0) + 1);
            }
        }
        
        answer = new int[max];
        
        for(int key : hm.keySet()) {
            answer[max - hm.get(key)] = key;
        }
        
        return answer;
    }
}