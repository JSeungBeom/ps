import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] power;
	static int[] dp;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());

		power = new int[N + 1];
		dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				if(power[i] < power[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
						
			answer = Math.max(answer, dp[i] + 1);
		}
		
		System.out.println(N - answer);
		
	}

}
