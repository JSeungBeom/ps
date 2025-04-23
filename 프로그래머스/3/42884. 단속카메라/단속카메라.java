import java.util.*;

class Solution {    
    public int solution(int[][] routes) {
        int answer = 1;
        
        int n = routes.length;
        
        if(n == 1) return 1;
                
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int st = routes[0][0];
        int en = routes[0][1];
        
        for(int i = 1; i < n; i++){
            if(en < routes[i][0]){
                answer++;
                en = routes[i][1];
            }
        }
        
        return answer;
    }
}