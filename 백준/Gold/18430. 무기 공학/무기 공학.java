import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] vis;
    static int answer = 0;

    static int[][] dx = {{0, 1}, {0, 1}, {0, -1}, {0, -1}};
    static int[][] dy = {{-1, 0}, {1, 0}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(answer);
    }

    static void solve(int depth, int strength) {
        if (depth == N * M) {
            answer = Math.max(answer, strength);
            return;
        }

        int x = depth / M;
        int y = depth % M;

        if (!vis[x][y]) {
            for (int d = 0; d < 4; d++) {
                int nx1 = x + dx[d][0];
                int ny1 = y + dy[d][0];
                int nx2 = x + dx[d][1];
                int ny2 = y + dy[d][1];

                if (OOB(nx1, ny1) || OOB(nx2, ny2)) continue;
                if (vis[nx1][ny1] || vis[nx2][ny2]) continue;

                vis[x][y] = vis[nx1][ny1] = vis[nx2][ny2] = true;
                int cur = board[x][y] * 2 + board[nx1][ny1] + board[nx2][ny2];
                solve(depth + 1, strength + cur);
                vis[x][y] = vis[nx1][ny1] = vis[nx2][ny2] = false;
            }
        }

        solve(depth + 1, strength);
    }

    static boolean OOB(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
