import java.util.*;

class Solution {
    
    static int[][] board;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][] dist;
    static int leber_x, leber_y, exit_x, exit_y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
     
    public int solution(String[] maps) {
        int answer = 1;
        
        int n = maps.length;
        int m = maps[0].length();
        
        board = new int[n][m];
        dist = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'S') {
                    q.offer(new int[] {i, j});
                    
                    dist[i][j] = 0;
                    board[i][j] = 1;
                }
                else if(maps[i].charAt(j) == 'L') {
                    leber_x = i; leber_y = j;
                    board[i][j] = 2;
                }
                else if(maps[i].charAt(j) == 'X') {
                    board[i][j] = -1;
                }
                else if(maps[i].charAt(j) == 'E') {
                    exit_x = i; exit_y = j;
                    board[i][j] = 3;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0 || board[nx][ny] == -1) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[] {nx, ny});
            }
        }
        
        if(dist[leber_x][leber_y] == -1)
            return -1;
        
        answer += dist[leber_x][leber_y];
        
        q.offer(new int[] {leber_x, leber_y});
        
      
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0 || board[nx][ny] == -1) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[] {nx, ny});
            }
        }
        
        answer += dist[exit_x][exit_y];
        
        if(dist[exit_x][exit_y] == -1)
            return -1;
        
        return answer;
    }
}