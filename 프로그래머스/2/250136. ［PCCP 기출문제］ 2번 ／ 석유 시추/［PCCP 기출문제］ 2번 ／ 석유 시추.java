import java.util.*;

class Solution {
    
    static boolean[][] vis;
    static Queue<int[]> queue = new ArrayDeque<>();
    static Gas[][] gas;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        int number = 1;
        
        vis = new boolean[n][m];
        gas = new Gas[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] || land[i][j] == 0) continue;
                
                bfs(i, j, n, m, number++, land);
            }
        }
        
        for(int i = 0; i < m; i++) {
            boolean[] visGas = new boolean[number];
            int sumGas = 0;
            
            for(int j = 0; j < n; j++) {
                if(land[j][i] != 0) {
                    Gas curGas = gas[j][i];
                    
                    if(!visGas[curGas.number]) {
                        sumGas += curGas.size;
                        visGas[curGas.number] = true;
                    }
                }    
            }
            
            answer = Math.max(answer, sumGas);
        }
        
        return answer;
    }

    static void bfs(int x, int y, int n, int m, int number, int[][] land) {
        List<int[]> list = new ArrayList<>();
        vis[x][y] = true;
        queue.add(new int[] {x, y});
        int size = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];
            list.add(new int[] {curX, curY});
            size++;
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] || land[nx][ny] == 0) continue;
                    
                vis[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
        }
        
        for(int[] cur : list) {
            gas[cur[0]][cur[1]] = new Gas(number, size);
        }
    }
    
    static class Gas {
        int number;
        int size;
        
        Gas(int number, int size) {
            this.number = number;
            this.size = size;
        }
    }
}