import java.util.*;

class Solution {

    static int[][][] board = new int[105][105][20005]; // [r][c][t]
    static Map<Integer, int[]> pos = new HashMap<>();

    public int solution(int[][] points, int[][] routes) {
        // 포인트 번호 -> (r, c) 0-index 매핑
        for (int i = 0; i < points.length; i++) {
            pos.put(i + 1, new int[]{points[i][0] - 1, points[i][1] - 1});
        }

        // 각 로봇을 절대시간 t 기준으로 기록 (모두 t=0 동시 출발)
        for (int i = 0; i < routes.length; i++) {
            int[] start = pos.get(routes[i][0]);
            int r = start[0], c = start[1];
            int t = 0;

            // 출발 시각(0초) 기록
            board[r][c][t]++;

            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] end = pos.get(routes[i][j + 1]);
                int tr = end[0], tc = end[1];

                // r 좌표를 먼저 맞춘다
                while (r != tr) {
                    r += (r < tr ? 1 : -1);
                    t++;
                    if (t <= 20000) board[r][c][t]++;
                }
                // 그다음 c 좌표
                while (c != tc) {
                    c += (c < tc ? 1 : -1);
                    t++;
                    if (t <= 20000) board[r][c][t]++;
                }
            }
        }

        // 같은 시간 t, 같은 좌표에 로봇 수 >= 2인 경우를 모두 합산
        int answer = 0;
        for (int t = 0; t <= 20000; t++) {
            for (int r = 0; r <= 100; r++) {
                for (int c = 0; c <= 100; c++) {
                    if (board[r][c][t] >= 2) answer++;
                }
            }
        }
        return answer;
    }
}
