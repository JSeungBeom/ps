import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][M + 1];
		
		dp[1][1] = 1;
		
		
		int row;
		int col;
		
		if(K == 0) {
			row = N;
			col = M;
		} 
		else {
			row = ((K - 1) / M) + 1;
			col = ((K - 1) % M) + 1;
		}
		
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + dp[i][j - 1]);
			}
		}
		
		for(int i = row; i <= N; i++) {
			for(int j = col; j <= M; j++) {
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
	
}