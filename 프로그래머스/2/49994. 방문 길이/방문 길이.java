class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] vis = new boolean[12][12][12][12];
    
    public int solution(String dirs) {
        int answer = 0;
    
        int[] cur = new int[] {5, 5};
        
        for(int i = 0; i < dirs.length(); i++) {
            int dir = -1;
            
            switch(dirs.charAt(i)) {
                case 'U' :
                    dir = 0;
                    break;
                case 'R' :
                    dir = 1;
                    break;
                case 'D' : 
                    dir = 2;
                    break;
                case 'L' :
                    dir = 3;
                    break;
            }
            
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                if(vis[cur[0]][cur[1]][nx][ny] || vis[nx][ny][cur[0]][cur[1]]) answer--;

                vis[cur[0]][cur[1]][nx][ny] = true;
                answer++;
                cur = new int[]{nx, ny};
        }
        
        
        return answer;
    }
}