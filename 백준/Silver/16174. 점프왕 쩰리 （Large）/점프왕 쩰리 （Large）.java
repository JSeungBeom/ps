import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static boolean[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        dp = new boolean[N + 1][N + 1];
        
        for(int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int j = 1; j <= N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dp[1][1] = board[1][1] >= 1 ? true : false;
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(!dp[i][j]) continue;
        		
        		if(!OOB(i + board[i][j], j))
        			dp[i + board[i][j]][j] = true;
        		
        		if(!OOB(i, j + board[i][j]))
        			dp[i][j + board[i][j]] = true;
        	}
        }
        
        System.out.println(dp[N][N] ? "HaruHaru" : "Hing");
    }
    
    static boolean OOB(int x, int y) {
    	return x <= 0 || x > N || y <= 0 || y > N;
    }
    
}

