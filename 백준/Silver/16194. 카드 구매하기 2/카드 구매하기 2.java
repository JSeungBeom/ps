import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] P;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		P = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N + 1];
		
		dp[1] = P[1];
		
		for(int i = 2; i <= N; i++) {
			dp[i] = P[i];
			for(int j = i; j >= 0; j--) {
				dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
			}
		}
		
		System.out.println(dp[N]);
		
  	}
}