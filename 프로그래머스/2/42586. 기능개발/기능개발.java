import java.util.*;

class Solution {
    
    static Queue<Integer> q = new ArrayDeque<>();
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        int n = progresses.length;
        
        for(int i = 0; i < n; i++) {
            if((100 - progresses[i]) % speeds[i] == 0)
                q.add((100 - progresses[i]) / speeds[i]);
            else
                q.add((100 - progresses[i]) / speeds[i] + 1);
        }
        
        int st = q.peek();
        int cnt = 0;
        
        
        while(!q.isEmpty()) { 
            int cur = q.poll();
            
            if(cur <= st) {
                cnt++;
            } 
            else {
                st = cur;
                list.add(cnt);
                cnt = 1;
            }
        }
        
        list.add(cnt);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}