import java.util.*;

class Solution {
    
    static int[][] board = new int[105][105];
    static int[][] dist = new int[105][105];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new ArrayDeque<>();
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int n = rectangle.length;
        
        // rectangle 채우기        
        for(int i = 0; i < n; i++) {
            int ldx = rectangle[i][0];
            int ldy = rectangle[i][1];
            int rux = rectangle[i][2];
            int ruy = rectangle[i][3];

            for(int j = ldy * 2; j <= ruy * 2; j++) {
                for(int k = ldx * 2; k <= rux * 2; k++) {
                    board[j][k] = 1;
                }
            }
        }
        
        // rectangle 비우기
        for(int i = 0; i < n; i++) {
            int ldx = rectangle[i][0];
            int ldy = rectangle[i][1];
            int rux = rectangle[i][2];
            int ruy = rectangle[i][3];

            for(int j = ldy * 2 + 1; j < ruy * 2; j++) {
                for(int k = ldx * 2 + 1; k < rux * 2; k++) {
                    board[j][k] = 0;
                }
            }
        }
        
        
        // bfs
        for(int i = 0; i <= 100; i++) 
            Arrays.fill(dist[i], -1);
        
        dist[characterY * 2][characterX * 2] = 0;
        
        q.offer(new int[] {characterY * 2, characterX * 2});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
                        
            if(x == itemY * 2 && y == itemX * 2) break;
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                if(board[nx][ny] == 0 || dist[nx][ny] >= 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[] {nx, ny});
            }
        }
        
        return dist[itemY * 2][itemX * 2] / 2;
    }
}