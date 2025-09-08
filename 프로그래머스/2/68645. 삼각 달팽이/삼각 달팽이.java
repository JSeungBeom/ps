import java.util.*;

class Solution {
    static int[][] snail;
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    static List<Integer> answer = new ArrayList<>();
    static int[] arr;
    
    public int[] solution(int n) {
        snail = new int[n + 1][n + 1];
        
        make_snail(0, 1, 1, n, 0);
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                if(snail[i][j] == 0) continue;
                answer.add(snail[i][j]);
            }
        }
        
        arr = new int[answer.size()];
        
        for(int i = 0; i < answer.size(); i++) {
            arr[i] = answer.get(i);
        }
    
        return arr;
    }
    
    static void make_snail(int x, int y, int cnt, int size, int dir) {
        if(size == 0) return;
                
        for(int i = 0; i < size; i++) {
            x += dx[dir];
            y += dy[dir];
            
            snail[x][y] = cnt++;

        }
        
        make_snail(x, y, cnt, size - 1, (dir + 1) % 3); 
    }
}

// 1
// 2 9
// 3 10 8
// 4 5  6 7