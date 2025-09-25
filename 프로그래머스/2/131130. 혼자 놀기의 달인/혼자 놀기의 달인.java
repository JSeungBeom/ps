import java.util.*;

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] vis = new boolean[cards.length];

        for(int rep = 0; rep < cards.length; rep++) {
            int cur = rep;
            int cnt = 0;
            
            for(int i = 0; i < cards.length; i++) {            
                while(!vis[cur]) {
                    vis[cur] = true;

                    cur = cards[cur] - 1;
                    cnt++;
                }
                
                break;
            }
 
            pq.add(cnt);
        }
        
        return pq.poll() * pq.poll();
    }
}