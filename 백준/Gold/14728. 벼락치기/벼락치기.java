import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	
	static int N, T;
	static int[] K;
	static int[] S;
	static int[][] dp;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		K = new int[N + 1];
		S = new int[N + 1];
		dp = new int[N + 1][T + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= T; j++) {
				if(j - K[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - K[i]] + S[i]);
				}
				else
					dp[i][j] = dp[i - 1][j];

				answer = Math.max(answer, dp[i][j]);
			}
		}
		
		System.out.println(answer);
	}

}
