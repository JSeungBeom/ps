import java.util.*;

class Solution {    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        int n = data.length;
        int m = data[0].length;
        
        Arrays.sort(data, (o1, o2) -> 
            (o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1])           
        );
        
        for(int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            
            for(int j = 0; j < m; j++) {
                sum += (data[i][j] % (i + 1));  
            }
            
            
            answer ^= sum;
        }
        
        return answer;
    }
}