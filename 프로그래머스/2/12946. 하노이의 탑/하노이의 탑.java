import java.util.*;

class Solution {    
    
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        
        int[][] answer = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
    static void hanoi(int n, int st, int en) {
        if(n == 0) return;
        
        hanoi(n - 1, st, 6 - st - en);
                
        list.add(new int[] {st, en});
        
        hanoi(n - 1, 6 - st - en, en);
    }
}