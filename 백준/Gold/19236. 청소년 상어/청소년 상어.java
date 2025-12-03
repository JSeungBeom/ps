import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static int answer = 0;

    static class Fish {
        int x, y, num, dir;
        boolean alive = true;

        Fish(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }

    static class Shark {
        int x, y, dir;

        Shark(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static Fish[][] copyMap(Fish[][] original) {
        Fish[][] copy = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Fish f = original[i][j];
                if (f != null) {
                    Fish newFish = new Fish(f.x, f.y, f.num, f.dir);
                    newFish.alive = f.alive;
                    copy[i][j] = newFish;
                }
            }
        }
        return copy;
    }

    static void moveFish(Fish[][] fishes, Shark shark) {
        // 1~16번 물고기 순서로 이동
        for (int num = 1; num <= 16; num++) {

            Fish fish = null;

            // 물고기 찾아오기
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (fishes[i][j] != null && fishes[i][j].num == num
                        && fishes[i][j].alive) {
                        fish = fishes[i][j];
                        break;
                    }
                }
            }

            if (fish == null) continue;

            for (int d = 0; d < 8; d++) {
                int nd = (fish.dir + d) % 8;
                int nx = fish.x + dx[nd];
                int ny = fish.y + dy[nd];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
                if (nx == shark.x && ny == shark.y) continue;

                Fish target = fishes[nx][ny];

                // swap or move
                fish.dir = nd;

                if (target != null) {
                    // swap
                    target.x = fish.x;
                    target.y = fish.y;
                    fishes[fish.x][fish.y] = target;
                } else {
                    fishes[fish.x][fish.y] = null;
                }

                fish.x = nx;
                fish.y = ny;
                fishes[nx][ny] = fish;
                break;
            }
        }
    }

    static void moveShark(Fish[][] fishes, Shark shark, int sum) {
        answer = Math.max(answer, sum);

        // 먼저 물고기 이동
        moveFish(fishes, shark);

        // 상어의 이동 → 1~3칸
        for (int step = 1; step <= 3; step++) {
            int nx = shark.x + dx[shark.dir] * step;
            int ny = shark.y + dy[shark.dir] * step;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
            if (fishes[nx][ny] == null) continue; // 물고기 없는 칸은 못 감

            // 깊은 복사
            Fish[][] nextMap = copyMap(fishes);

            // 먹을 물고기
            Fish fish = nextMap[nx][ny];

            // 상어 정보 세팅
            Shark nextShark = new Shark(nx, ny, fish.dir);

            // 물고기 제거
            fish.alive = false;
            nextMap[nx][ny] = null;

            // DFS
            moveShark(nextMap, nextShark, sum + fish.num);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Fish[][] fishes = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishes[i][j] = new Fish(i, j, num, dir);
            }
        }

        // 상어가 (0,0) 먹음
        Fish first = fishes[0][0];
        Shark shark = new Shark(0, 0, first.dir);
        first.alive = false;
        fishes[0][0] = null;

        moveShark(fishes, shark, first.num);

        System.out.println(answer);
    }
}
