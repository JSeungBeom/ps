class Solution {
    
    // 우하좌상
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy1 = {0, 1, 0, -1};
    // 우하, 좌하, 좌상, 우상
    static int[] dx2 = {1, -1, -1, 1};
    static int[] dy2 = {1, 1, -1, -1};
    static int[] dx3 = {2, 0, -2, 0};
    static int[] dy3 = {0, 2, 0, -2};
    
    static char[][] board = new char[5][5];
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < places.length; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    board[j][k] = places[i][j].charAt(k);
                }
            }
            
            
            answer[i] = checkDistance();
        }
        
        return answer;
    }
    
    static int checkDistance() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                
                if(board[i][j] == 'P') { 
                    // 상하좌우 -> 무조건 X
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx1[dir];
                        int ny = j + dy1[dir];

                        if(OOB(nx, ny)) continue;
                        
                        if(board[nx][ny] == 'P') return 0;
                    }
                    
                    // 대각선
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx2[dir];
                        int ny = j + dy2[dir];
                        
                        if(OOB(nx, ny)) continue;
                        
                        if(board[nx][ny] == 'P') {
                            int nnx1 = i + dx1[(dir) % 4];
                            int nny1 = j + dy1[(dir) % 4];
                            
                            int nnx2 = i + dx1[(dir + 1) % 4];
                            int nny2 = j + dy1[(dir + 1) % 4];
                            
                            if(board[nnx1][nny1] != 'X'
                               || board[nnx2][nny2] != 'X') return 0;
                        }
                    }
                    
                    // 2칸 상하좌우
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx3[dir];
                        int ny = j + dy3[dir];
                        
                        if(OOB(nx, ny)) continue;
                        
                        if(board[nx][ny] == 'P') {
                        
                            int nnx = i + dx1[dir];
                            int nny = j + dy1[dir];

                            if(board[nnx][nny] != 'X') return 0;
                        }
                    }
                }
            }
        }
        
        return 1;
    }
    
    static boolean OOB(int x, int y) {
        return x < 0 || x >= 5 || y < 0 || y >= 5;
    }
}