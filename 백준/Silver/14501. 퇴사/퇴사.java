import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[] T;
	static int[] P;
	static int[] dp;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		T = new int[N + 1];
		P = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				if(i + T[i] <= N + 1) {
					if(j + T[j] <= i) {
						dp[i] = Math.max(dp[i], dp[j] + P[i]);
					}
					else {
						dp[i] = Math.max(dp[i], P[i]);
					}
				}
			}
			answer = Math.max(dp[i], answer);

		}
				
		System.out.println(answer);
	}
	
}