import java.util.*;

class Solution {
    
    static boolean[][] vis;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        vis = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j] || picture[i][j] == 0) continue;
                
                vis[i][j] = true;
                q.offer(new int[] {i, j});
                numberOfArea++;
                
                int area = 0;
                
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    
                    int x = cur[0];
                    int y = cur[1];
                    area++;
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if(vis[nx][ny] || picture[nx][ny] != picture[x][y]) continue;
                        
                        vis[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
                
                maxSizeOfOneArea = Math.max(area, maxSizeOfOneArea);
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}