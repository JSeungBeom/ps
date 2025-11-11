import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int r, c;
	static int answer;
	static boolean[][] board;
	static boolean[][] vis;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		vis = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			board[r - 1][c - 1] = true;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(vis[i][j] || !board[i][j]) continue;
				
				vis[i][j] = true;
				queue.add(new int[] {i, j});
				int size = 0;
				
				while(!queue.isEmpty()) {
					int[] cur = queue.poll();
					int x = cur[0];
					int y = cur[1];
					size++;
					
					answer = Math.max(size, answer);
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						if(vis[nx][ny] || !board[nx][ny]) continue;
						
						vis[nx][ny]	= true;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
