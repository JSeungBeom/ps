import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        for(; i < enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];
            
            if(n < 0) {
                if(k > 0) {
                    n += pq.poll(); 
                    k--;
                } else {
                    break; 
                }
            }
        }
        return i;
    }
}
