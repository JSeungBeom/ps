import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        divideSector();
        findMin();
        
        System.out.println(answer);
        
    }
    
    static void findMin() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 0) continue;
					
				int[][] dist = new int[N][N];
		    	Queue<int[]> q = new ArrayDeque<>();
				
				for(int k = 0; k < N; k++) Arrays.fill(dist[k], -1);
		    	
				q.add(new int[] {i, j});
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					int x = cur[0];
					int y = cur[1];
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(dist[nx][ny] >= 0 || board[nx][ny] == board[i][j]) continue;
						
						if(board[nx][ny] > 0) {
							answer = Math.min(answer, dist[x][y] + 1);
						}
						
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new int[] {nx, ny});
					}
				}
				
			}
		}
    }
    
    static void divideSector() {
    	Queue<int[]> q = new ArrayDeque<>();
    	boolean[][] vis = new boolean[N][N];
    	int start = 0;
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(board[i][j] == 0 || vis[i][j]) continue;
    			
    			start++;
    			vis[i][j] = true;
    			board[i][j] = start;
    			
    			q.add(new int[] {i, j});
    			
    			while(!q.isEmpty()) {
    				int[] cur = q.poll();
    				
    				int x = cur[0];
    				int y = cur[1];
    				
    				for(int dir = 0; dir < 4; dir++) {
    					int nx = x + dx[dir];
    					int ny = y + dy[dir];
    					
    					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
    					if(board[nx][ny] == 0 || vis[nx][ny]) continue;
    					
    					vis[nx][ny] = true;
    					board[nx][ny] = start;
    					q.add(new int[] {nx, ny});
    				}
    			}
    		}
    	}
    }
}