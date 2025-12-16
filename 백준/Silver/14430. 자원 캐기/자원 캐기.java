import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        
        board = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        
        for(int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 1; j <= M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= M; j++) {
        		dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
        	}
        }
        
        System.out.println(dp[N][M]);
    }
}
