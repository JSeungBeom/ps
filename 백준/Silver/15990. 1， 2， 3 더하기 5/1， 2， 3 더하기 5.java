import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int T, n;
	static long[][] dp;
	static final int div = 1000000009;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		dp = new long[100005][4];
	
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = dp[3][2] = dp[3][3] = 1;
		
		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % div;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % div;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % div;
		}
		
		for(int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			
			System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % div);
		}		
	}
	
	// 4 
	// 1 + 2 + 1
	// 1 + 3
	// 3 + 1
	
}