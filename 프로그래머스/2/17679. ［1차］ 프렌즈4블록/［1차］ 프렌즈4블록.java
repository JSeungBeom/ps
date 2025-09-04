import java.util.*;

class Solution {
    static char[][] game;
    static int m, n;
    static int answer;

    public int solution(int m, int n, String[] board) {
        Solution.m = m;
        Solution.n = n;
        answer = 0;

        game = new char[m][n];
        for (int i = 0; i < m; i++) {
            game[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] mark = new boolean[m][n];
            int erased = markErasable(mark); 
            if (erased == 0) break;          
            answer += erased;
            applyGravity(mark);               
        }

        return answer;
    }

    static int markErasable(boolean[][] mark) {
        int cnt = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = game[i][j];
                if (c == '*') continue; 

                if (game[i][j + 1] == c &&
                    game[i + 1][j] == c &&
                    game[i + 1][j + 1] == c) {
                    mark[i][j] = mark[i][j + 1] = mark[i + 1][j] = mark[i + 1][j + 1] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j]) {
                    game[i][j] = '*';
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void applyGravity(boolean[][] mark) {
        for (int col = 0; col < n; col++) {
            int write = m - 1; 
            for (int row = m - 1; row >= 0; row--) {
                if (game[row][col] != '*') {
                    game[write][col] = game[row][col];
                    if (write != row) game[row][col] = '*';
                    write--;
                }
            }
            
            for (int row = write; row >= 0; row--) {
                game[row][col] = '*';
            }
        }
    }
}
