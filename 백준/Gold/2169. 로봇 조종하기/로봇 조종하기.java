import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] board;
	static int[][] dp;	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N + 2][M + 2];
        dp = new int[N + 2][M + 2];
        
        for(int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i <= M; i++) {
        	dp[1][i] = dp[1][i - 1] + board[1][i]; 
        }
        
        for(int i = 2; i <= N; i++) {
        	int[] left = new int[M + 2];
        	int[] right = new int[M + 2];
        	
        	Arrays.fill(left, Integer.MIN_VALUE);
        	Arrays.fill(right, Integer.MIN_VALUE);
        	
        	for(int j = 1; j <= M; j++) {
        		left[j] = Math.max(dp[i - 1][j], left[j - 1]) + board[i][j];
        	}
        	
        	for(int j = M; j >= 1; j--) {
        		right[j] = Math.max(dp[i - 1][j], right[j + 1]) + board[i][j];
        	}
        	
        	for(int j = 1; j <= M; j++) {
        		dp[i][j] = Math.max(left[j], right[j]);
        	}
        	
        } 
        
        System.out.println(dp[N][M]);
        
    }
}