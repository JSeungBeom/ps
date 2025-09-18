import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) Arrays.fill(cost[i][j], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        if (n > 1 && board[1][0] == 0) {
            cost[1][0][0] = 100;                 // 하(0)
            pq.offer(new int[]{100, 1, 0, 0});
        }
        if (n > 1 && board[0][1] == 0) {
            cost[0][1][1] = 100;                 // 우(1)
            pq.offer(new int[]{100, 0, 1, 1});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int c = cur[0], x = cur[1], y = cur[2], dir = cur[3];

            if (c > cost[x][y][dir]) continue; // 이미 더 좋은 경로가 있음

            for (int ndir = 0; ndir < 4; ndir++) {
                int nx = x + dx[ndir];
                int ny = y + dy[ndir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int add = (dir == ndir) ? 100 : 600; // 직선 or 코너
                int nc = c + add;
                if (cost[nx][ny][ndir] > nc) {
                    cost[nx][ny][ndir] = nc;
                    pq.offer(new int[]{nc, nx, ny, ndir});
                }
            }
        }

        int ans = INF;
        for (int d = 0; d < 4; d++) ans = Math.min(ans, cost[n-1][n-1][d]);
        return (ans == INF) ? 0 : ans;
    }
}
