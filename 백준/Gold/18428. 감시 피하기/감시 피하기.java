import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static char[][] board;
	static int[] arr = new int[3];
	static boolean[] vis;
	static List<int[]> teachers = new ArrayList<>();
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	static boolean isCompleted;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];
        vis = new boolean[N * N];
        
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < N; j++) {
        		board[i][j] = st.nextToken().charAt(0);
        		
        		if(board[i][j] == 'T')
        			teachers.add(new int[] {i, j});
        	}
        }
        
        backTracking(0, 3, 0);
        
        if(isCompleted)
        	System.out.println("YES");
        else
        	System.out.println("NO");
    }
    
    static void backTracking(int n, int k, int st) {
    	if(isCompleted) return;
    	
    	if(n == k) {
    		if(checkBoard(n)) isCompleted = true;
    			
    		return;
    	}
    	
    	for(int i = st; i < N * N; i++) {
    		if(vis[i]) continue;
    		
    		arr[n] = i;
    		vis[i] = true;
    		backTracking(n + 1, k, i + 1);
    		vis[i] = false;
    	}
    }
    
    static boolean checkBoard(int n) {
    	char[][] tmpBoard = new char[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			tmpBoard[i][j] = board[i][j];
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		int cur = arr[i];
    		
    		int x = cur / N;
    		int y = cur % N;
    		
    		if(tmpBoard[x][y] == 'T' || tmpBoard[x][y] == 'S') return false;
    		
    		tmpBoard[x][y] = 'O';
    	}
    	
    	for(int[] teacher : teachers) { 
    		int x = teacher[0];
    		int y = teacher[1];
    		
    		for(int dir = 0; dir < 4; dir++) {
    			int nx = x + dx[dir];
    			int ny = y + dy[dir];
    			
    			while(true) {
	    			if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
	    			if(tmpBoard[nx][ny] == 'O') break;
	    			if(tmpBoard[nx][ny] == 'S') return false;
	    			
	    			nx += dx[dir];
	    			ny += dy[dir];
    			}
    		}
    	}
    	
    	return true;
    	
    }

   
}

