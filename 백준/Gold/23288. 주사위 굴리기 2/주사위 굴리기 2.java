import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int answer;
	static int[][] board;
	static int[][] points;
	static int[] diceX = new int[] {4, 1, 3, 6};
	static int[] diceY = new int[] {2, 1, 5, 6};
	
	static int[] cur = new int[] { 1, 1 };
	static int[] dx = new int[] { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dy = new int[] { 0, 1, 0, -1 };
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	board = new int[N + 1][M + 1];
    	points = new int[N + 1][M + 1];
    	
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int dir = 1;
		
		for(int i = 0; i < K; i++) {
			int[] now = move(dir);
			cur = new int[] {now[0], now[1]};
			dir = now[2];

			answer += getPoint(cur[0], cur[1]);
			dir = getDirection(cur[0], cur[1], dir);
		
		}
    	
		System.out.println(answer);
    }
    
    static int getDirection(int x, int y, int dir) {
    	int down = diceX[3];
    	
    	if(down > board[x][y]) {
    		return (dir + 1) % 4;
    	}
    	else if(down < board[x][y]) {
    		if(dir - 1 < 0)
    			return 3;
    		return dir - 1;
    	}

    	return dir;
    }
    
    static int getPoint(int x, int y) {
    	return points[x][y] * board[x][y];
    }
    
    static void bfs() {
    	Queue<int[]> queue = new ArrayDeque<>();
    	boolean[][] vis = new boolean[N + 1][M + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= M; j++) {
    			if(vis[i][j]) continue;
    			
    			List<int[]> list = new ArrayList<>();
    			int cnt = 0;
    			vis[i][j] = true;
    			queue.add(new int[] {i, j});
    			
    			while(!queue.isEmpty()) {
    				int[] curPoint = queue.poll();
    				
    				int x = curPoint[0];
    				int y = curPoint[1];
    				
    				list.add(new int[] {x, y});
    				cnt++;
    				
    				for(int direction = 0; direction < 4; direction++) {
    					int nx = x + dx[direction];
    					int ny = y + dy[direction];
    					
    					if(OOB(nx, ny)) continue;
    					if(vis[nx][ny] || board[nx][ny] != board[i][j]) continue;
    					
    					vis[nx][ny] = true;
    					queue.add(new int[] {nx, ny});
    				}
    			}
    			
    			for(int[] cur : list) {
    				points[cur[0]][cur[1]] = cnt;
    			}
    		}
    	}
    }

    
    static void adjustDice(int dir) {
    	switch(dir) {
    		case 0 :
    			int tmp = diceY[0];
	    		
	    		for(int i = 0; i <= 2; i++) {
	    			diceY[i] = diceY[i + 1];
	    		}
	    		
	    		diceY[3] = tmp;
	    		
	    		diceX[1] = diceY[1];
	    		diceX[3] = diceY[3];
	    		break;

    		case 1 :
	    		tmp = diceX[3];
	    		
	    		for(int i = 3; i >= 1; i--) {
	    			diceX[i] = diceX[i - 1];
	    		}
	    		
	    		diceX[0] = tmp;
	    		
	    		diceY[1] = diceX[1];
	    		diceY[3] = diceX[3];
	    		break;
	    		
    		case 2 :
	    		tmp = diceY[3];
	    		
	    		for(int i = 3; i >= 1; i--) {
	    			diceY[i] = diceY[i - 1];
	    		}
	    		
	    		diceY[0] = tmp;
	    		
	    		diceX[1] = diceY[1];
	    		diceX[3] = diceY[3];
	    		break;
	    		
    		case 3 :
    			tmp = diceX[0];
	    		
	    		for(int i = 0; i <= 2; i++) {
	    			diceX[i] = diceX[i + 1];
	    		}
	    		
	    		diceX[3] = tmp;
	    		
	    		diceY[1] = diceX[1];
	    		diceY[3] = diceX[3];
	    		break;
    	}
    }
    
    static int[] move(int dir) {
    	int nx = cur[0] + dx[dir];
    	int ny = cur[1] + dy[dir];
    	
    	if(OOB(nx, ny)) {
    		dir = (dir + 2) % 4;
    		
    		nx = cur[0] + dx[dir];
    		ny = cur[1] + dy[dir];
    	}
    
    	adjustDice(dir);
    	
    	return new int[] {nx, ny, dir};
    }
    
    static boolean OOB(int x, int y) {
    	return x < 1 || x > N || y < 1 || y > M;
    }

}

