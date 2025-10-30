class Solution {
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] vis;
    static int answer = Integer.MAX_VALUE;
    static int rx, ry, bx, by;
    static int n, m;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        
        vis = new boolean[n][m][2];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == 1) {
                    rx = i; ry = j;
                }
                
                if(maze[i][j] == 2) {
                    bx = i; by = j;
                }
            }
        }
        
        vis[rx][ry][0] = true;
        vis[bx][by][1] = true;
        
        dfs(rx, ry, bx, by, 0, maze);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    static void dfs(int rx, int ry, int bx, int by, int turn, int[][] maze) {
        if(maze[rx][ry] == 3 && maze[bx][by] == 4) {
            answer = Math.min(answer, turn);
            return;
        }
                
        for(int dir = 0; dir < 4; dir++) {
            int nrx = rx;
            int nry = ry;
            
            if(maze[nrx][nry] != 3) {
                nrx += dx[dir];
                nry += dy[dir];

                if(nrx < 0 || nrx >= n || nry < 0 || nry >= m) continue;
                if(vis[nrx][nry][0] || maze[nrx][nry] == 5) continue;

                vis[nrx][nry][0]= true;
            }
            
            for(int ddir = 0; ddir < 4; ddir++) {
                int nbx = bx;
                int nby = by;
                
                if(maze[nbx][nby] != 4) {
                    nbx += dx[ddir];
                    nby += dy[ddir];

                    if(nbx < 0 || nbx >= n || nby < 0 || nby >= m) continue;
                    if(vis[nbx][nby][1] || maze[nbx][nby] == 5) continue;
                }
                
                if((nbx == nrx && nby == nry) 
                    || (nbx == rx && nby == ry && nrx == bx && nry == by)) continue;
                
                vis[nbx][nby][1] = true;
                dfs(nrx, nry, nbx, nby, turn + 1, maze);
                vis[nbx][nby][1] = false;
            }
            
            vis[nrx][nry][0] = false;
            
        }
    }
}