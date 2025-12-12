import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] board;
	static int[][][] dist;
	static int endX, endY;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        Queue<int[]> waterQueue = new ArrayDeque<>();
        Queue<int[]> dochiQueue = new ArrayDeque<>();
        
        board = new char[R][C];
        dist = new int[R][C][3];
        
        for(int i = 0; i < R; i++)
        	for(int j = 0; j < C; j++)
        		Arrays.fill(dist[i][j], -1);
        
        for(int i = 0; i < R; i++) {
        	String S = br.readLine();
        	
        	for(int j = 0; j < C; j++) {
        		board[i][j] = S.charAt(j);
        		
        		if(board[i][j] == 'D') {
        			endX = i;
        			endY = j;
        		}
        		if(board[i][j] == '*') {
        			waterQueue.add(new int[] {i, j, 1});
        			dist[i][j][1] = 0;
        		}
        		if(board[i][j] == 'S') {
        			dochiQueue.add(new int[] {i, j, 2});
        			dist[i][j][2] = 0;
        		}
        	}
        }
        
        bfs(waterQueue, 1);
        bfs(dochiQueue, 2);
        
        
        int answer = dist[endX][endY][2];
        
        System.out.println(answer == -1 ? "KAKTUS" : answer);
        
    }
    
    static void bfs(Queue<int[]> queue, int type) {
    	while(!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		
    		int x = cur[0];
    		int y = cur[1];
    		
    		for(int dir = 0; dir < 4; dir++) {
    			int nx = x + dx[dir];
    			int ny = y + dy[dir];
    			
    			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
    			
    			if(type == 1) {
    				if(dist[nx][ny][1] >= 0 || board[nx][ny] == 'X' || board[nx][ny] == 'D') continue;
    				
    				dist[nx][ny][1] = dist[x][y][1] + 1;
    				queue.add(new int[] {nx ,ny, 1});
    			}
    			else {
    				if((dist[nx][ny][1] >= 0 && dist[nx][ny][1] <= dist[x][y][2] + 1) 
    						|| dist[nx][ny][2] >= 0 
    						|| board[nx][ny] == 'X') continue;
    				
    				dist[nx][ny][2] = dist[x][y][2] + 1;
    				queue.add(new int[] {nx, ny, 2});
    			}
    		}
    	}
    }
    

}