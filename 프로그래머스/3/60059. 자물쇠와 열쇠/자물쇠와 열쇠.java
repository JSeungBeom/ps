import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        int pad = m - 1;
        int size = n + 2 * pad;
        int[][] board = new int[size][size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + pad][j + pad] = lock[i][j];
            }
        }

        int[][] cur = key;
        for (int r = 0; r < 4; r++) {
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {
                    add(board, cur, x, y);
                    if (isUnlocked(board, pad, n)) return true;
                    sub(board, cur, x, y);
                }
            }
            cur = rotate90(cur);
        }

        return false;
    }

    private void add(int[][] board, int[][] key, int sx, int sy) {
        int m = key.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                board[sx + i][sy + j] += key[i][j];
            }
        }
    }

    private void sub(int[][] board, int[][] key, int sx, int sy) {
        int m = key.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                board[sx + i][sy + j] -= key[i][j];
            }
        }
    }

    private boolean isUnlocked(int[][] board, int pad, int n) {
        for (int i = pad; i < pad + n; i++) {
            for (int j = pad; j < pad + n; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    private int[][] rotate90(int[][] a) {
        int m = a.length;
        int[][] r = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                r[i][j] = a[m - 1 - j][i];
            }
        }
        return r;
    }
}
