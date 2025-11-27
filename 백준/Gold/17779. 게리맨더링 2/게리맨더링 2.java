import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static int[][] area;
	static int[] arr;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[]	{0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    	N = Integer.parseInt(br.readLine());
    	
    	board = new int[N + 1][N + 1];
    	area = new int[N + 1][N + 1];
    	
    	arr = new int[4];
    	
    	for(int i = 1; i <= N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	perm(0);
    	
    	System.out.println(answer);
    }
    
    static void perm(int cur) {
    	if(cur == 4) {
    		int x = arr[0];
    		int y = arr[1];
    		int d1 = arr[2];
    		int d2 = arr[3];
    		
    		if(x + d1 + d2 > N || y - d1 < 1 || y + d2 > N) return; 
    		
    		divideArea(x, y, d1, d2);
    		answer = Math.min(answer, getMinDifference());
    		
    		return;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		arr[cur] = i + 1;
    		perm(cur + 1);
    	}
    }
    
    static int getMinDifference() {
    	Queue<int[]> queue = new ArrayDeque<>();
    	boolean[][] vis = new boolean[N + 1][N + 1];
    	boolean[] isUsed = new boolean[6];
    	
    	int max = 0;
    	int min = Integer.MAX_VALUE;
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			if(vis[i][j]) continue;
    			if(isUsed[area[i][j]]) return Integer.MAX_VALUE;
    			
    			vis[i][j] = true;
    			isUsed[area[i][j]] = true;
    			queue.add(new int[] {i, j});
    			
    			int sum = 0;
    			
    			while(!queue.isEmpty()) {
    				int[] cur = queue.poll();
    				
    				int x = cur[0];
    				int y = cur[1];
    				sum += board[x][y];
    				
    				for(int dir = 0; dir < 4; dir++) {
    					int nx = x + dx[dir];
    					int ny = y + dy[dir];
    					
    					if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
    					if(vis[nx][ny] || area[nx][ny] != area[i][j]) continue;
    					
    					vis[nx][ny] = true;
    					queue.add(new int[] {nx, ny});
    				}
    			}
    			
    			max = Math.max(max, sum);
    			min = Math.min(min, sum);
    		}
    	}
    	
    	for(int i = 1; i <= 5; i++) 
    		if(!isUsed[i]) return Integer.MAX_VALUE;
    	
    	return max - min;
    }
    
    static void fillArea() {
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			if(area[i][j] == 0) area[i][j] = 5;
    		}
    	}
    }
    static void divideArea(int x, int y, int d1, int d2) {
    	drawLine(x, y, d1, d2);
    	decideArea(x, y, d1, d2);
    	fillArea();
    	
    }
    
    static void drawLine(int x, int y, int d1, int d2) {
    	area = new int[N + 1][N + 1];
    	
    	
    	for(int i = x, j = y; i <= x + d1 && j >= y - d1; i++, j--) {
    		area[i][j] = 5;
    	}
    	
    	for(int i = x, j = y; i <= x + d2 && j <= y + d2; i++, j++) {
    		area[i][j] = 5;
    	}
    	
    	for(int i = x + d1, j = y - d1; i <= x + d1 + d2 && j <= y - d1 + d2; i++, j++) {
    		area[i][j] = 5;
    	}
    	
    	for(int i = x + d2, j = y + d2; i <= x + d2 + d1 && j >= y + d2 - d1; i++, j--) {
    		area[i][j] = 5;
    	}
    }
    
    static void decideArea(int x, int y, int d1, int d2) {
    	// 1
    	for(int i = 1; i < x + d1; i++) {
    		for(int j = 1; j <= y; j++) {
    			if(area[i][j] == 5) break;
    			area[i][j] = 1;
    		}
    	}
    	
    	// 3
    	for(int i = x + d1; i <= N; i++) {
    		for(int j = 1; j < y - d1 + d2; j++) {
    			if(area[i][j] == 5) break;
    			area[i][j] = 3;
    		}
    	}
    	
    	// 2
    	for(int i = 1; i <= x + d2; i++) {
    		for(int j = N; j >= y + 1; j--) {
    			if(area[i][j] == 5) break;
				area[i][j] = 2;
    		}
    	}
    	
    	// 4
    	for(int i = x + d2 + 1; i <= N; i++) {
    		for(int j = N; j >= y - d1 + d2; j--) {
    			if(area[i][j] == 5) break;
				area[i][j] = 4;
    		}
    	}
    	
    }
}