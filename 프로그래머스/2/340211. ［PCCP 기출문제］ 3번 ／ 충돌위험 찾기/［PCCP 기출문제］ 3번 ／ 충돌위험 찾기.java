import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] board = new int[105][105][20005];
    static int turn = 0;
    static Map<Integer, int[]> map = new HashMap<>();
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
                
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0] - 1;
            int y = points[i][1] - 1;
            
            map.put(i + 1, new int[] {x, y});
        }
        
        move(routes);        
        
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                for(int turn = 0; turn < 20005; turn++) {
                    if(board[i][j][turn] >= 2) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static void move(int[][] routes) {
        for(int i = 0; i < routes.length; i++) {
            turn = 0;            
            for(int j = 0; j < routes[i].length - 1; j++) {
                int[] start = map.get(routes[i][j]);
                int[] end = map.get(routes[i][j + 1]);
                
                int curX = start[0]; 
                int curY = start[1];
                
                int endX = end[0];
                int endY = end[1];
                
                while(true) {                    
                    if(curX == endX && curY == endY) {
                        if(j == routes[i].length - 2) {
                            turn++;
                            board[curX][curY][turn]++;
                        }
                        break;
                    }
                    
                    turn++;
                    board[curX][curY][turn]++;
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = curX + dx[dir];
                        int ny = curY + dy[dir];
                        
                        if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
                        
                        int cur = Math.abs(curX - endX) + Math.abs(curY - endY);
                        int nxt = Math.abs(nx - endX) + Math.abs(ny - endY);
                        
                        if(cur > nxt) {
                            curX = nx;
                            curY = ny;
                            break;
                        }
                    }
                }
            }
        }
    }
}