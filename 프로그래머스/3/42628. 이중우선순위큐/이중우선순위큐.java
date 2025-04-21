import java.util.*;

class Solution {
    
    static TreeSet<Integer> set = new TreeSet<>();
    
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        for(int i = 0; i < operations.length; i++){
            String[] op = operations[i].split(" ");
            int num = Integer.parseInt(op[1]);
                
            if(op[0].equals("I")){
                set.add(num);
            } 
            else {
                if(num == 1){
                    set.pollLast();
                }
                else {
                    set.pollFirst();
                }
            }
        }
        
        if(!set.isEmpty()) {
            answer[0] = set.last();
            answer[1] = set.first();
        }
        
        return answer;
    }
}