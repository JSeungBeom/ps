import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] lost;
	static int[] happy;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		lost = new int[N + 1];
		happy = new int[N + 1];
		dp = new int[N + 1][101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			lost[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp[0], -1);
		
		dp[0][100] = 0;
		
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= 100; j++) {
				if(dp[i - 1][j] >= 0) {
					if(j - lost[i] > 0) {
					    dp[i][j - lost[i]] = Math.max(dp[i][j - lost[i]], dp[i - 1][j] + happy[i]);
					} 
					
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 1; i <= 100; i++) {
			ans = Math.max(ans, dp[N][i]);
		}
		
		System.out.println(ans);
  	}
}