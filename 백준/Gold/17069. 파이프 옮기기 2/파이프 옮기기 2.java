import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static long[][][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	board = new int[N + 1][N + 1];
    	dp = new long[N + 1][N + 1][3];
    	
    	for(int i = 1; i <= N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		for(int j = 1; j <= N; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dp[1][2][0] = 1;
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 2; j <= N; j++) {
    			if(!OOB(i, j + 1)) {
    				dp[i][j + 1][0] += (dp[i][j][0] + dp[i][j][2]);
    			}
    			
    			if(!OOB(i + 1, j)) {
    				dp[i + 1][j][1] += (dp[i][j][1] + dp[i][j][2]);
    			}
    			
    			if(!OOB(i, j + 1) && !OOB(i + 1, j + 1) && !OOB(i + 1, j)) {
    				dp[i + 1][j + 1][2] += (dp[i][j][0] + dp[i][j][1] + dp[i][j][2]);
    			}
    			
    		}
    	}
    	

    	
    	System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    	
    }
    
    static boolean OOB(int x, int y) {
    	return x < 1 || x > N || y < 1 || y > N || board[x][y] == 1;
    }

}

