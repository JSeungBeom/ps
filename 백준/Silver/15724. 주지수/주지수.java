import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
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
        

        
        K = Integer.parseInt(br.readLine());
        
        // 3 3 , 4 4 
        // - 4 2 - 2 4 + 2 2
        
        for(int i = 1; i <= N; i++) {
        	int[] psum = new int[M + 1];
        	
        	for(int j = 1; j <= M; j++) {
        			psum[j] = psum[j - 1] + board[i][j];
        			dp[i][j] = dp[i - 1][j] + psum[j];
        	}
        }
        
        for(int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	int answer = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
        	
        	System.out.println(answer);
        }
        
        
    }

}

