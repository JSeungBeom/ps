import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	
	static int T, N, M;
	static int[] coins;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			
			coins = new int[N + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j = 1; j <= N; j++) {
				coins[j] = Integer.parseInt(st.nextToken());		
			}
			
			M = Integer.parseInt(br.readLine());
			
			dp = new int[M + 1];
			
			dp[0] = 1;
			
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= M; k++) {
					if(k - coins[j] >= 0) {
						dp[k] += dp[k - coins[j]];
					}
				}
			}
			
 
			
			System.out.println(dp[M]);
		}
		
		
	}

}

// 1 
// 1 1, 2
// 1 1 1, 2 1