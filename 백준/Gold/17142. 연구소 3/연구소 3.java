import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	
	static int[][] board;
	static int N, M;
	static int min = Integer.MAX_VALUE;
	static final int ACTIVE_VIRUS = 3;
	static final int INACTIVE_VIRUS = 4;
	static List<int[]> virusList = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2)
					virusList.add(new int[] {i, j});
			}
		}
		
		selectActiveVirus(0, M, 0, new int[M][2], new boolean[virusList.size()]);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void selectActiveVirus(int n, int k, int st, int[][] arr, boolean[] vis) {
		if(n == k) {
			min = Math.min(min, getSpreadTime(arr));
			
			return;
		}
		
		for(int i = st; i < virusList.size(); i++) {
			if(vis[i]) continue;
			
			arr[n] = virusList.get(i);
			vis[i] = true;
			selectActiveVirus(n + 1, k, i + 1, arr, vis);
			vis[i] = false;
		}
	}
	
	static int getSpreadTime(int[][] arr) {
		int[][] copiedBoard = new int[N][N];
		int[][] dist = new int[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
			
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 2)
					copiedBoard[i][j] = INACTIVE_VIRUS;
				else
					copiedBoard[i][j] = board[i][j];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			int row = arr[i][0];
			int col = arr[i][1];
						
			copiedBoard[row][col] = ACTIVE_VIRUS;
			q.add(new int[] {row, col});
			dist[row][col] = 0;
		}
				
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(dist[nx][ny] >= 0 || copiedBoard[nx][ny] == 1) continue;
				
				dist[nx][ny] = dist[x][y] + 1;
				q.add(new int[] {nx, ny});
			}
		}
		
		int time = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copiedBoard[i][j] == INACTIVE_VIRUS) continue;
				if(dist[i][j] == -1 && board[i][j] != 1) return Integer.MAX_VALUE;

				time = Math.max(time, dist[i][j]);
			}			
		}
				
				
		return time;
	}
}