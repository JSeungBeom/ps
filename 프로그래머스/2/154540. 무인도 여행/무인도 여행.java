import java.util.*;

class Solution {
    
    static int[][] board;
    static boolean[][] vis;
    static Queue<int[]> q = new ArrayDeque<>();
    static List<Integer> answers = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        int[] answer;
        
        int n = maps.length;
        int m = maps[0].length();
        
        board = new int[n][m];
        vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'X')
                    board[i][j] = 0;
                else
                    board[i][j] = maps[i].charAt(j) - '0';
            }
        }

        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] || board[i][j] == 0) continue;
                
                vis[i][j] = true;
                q.offer(new int[] {i, j});
                int cnt = 0;
                
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    
                    int x = cur[0];
                    int y = cur[1];
                    
                    cnt += board[x][y];
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || board[nx][ny] == 0) continue;
                        
                        vis[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
                
                answers.add(cnt);
            }
        }
        
        if(answers.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } 
        else {
            answer = new int[answers.size()];
            
            for(int i = 0; i < answers.size(); i++) {
                answer[i] = answers.get(i);
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}