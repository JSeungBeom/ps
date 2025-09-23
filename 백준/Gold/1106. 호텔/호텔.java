import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	static int C, N;
	static int[] cost, customer;
	static int[] dp;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		cost = new int[N];
		customer = new int[N];
		
		dp = new int[2005];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			cost[i] = Integer.parseInt(st.nextToken());
			customer[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i = 0; i < N; i++) {
			if(dp[customer[i]] == 0)
				dp[customer[i]] = cost[i];
			else
				dp[customer[i]] = Math.min(dp[customer[i]], cost[i]);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= 2000; j++) {
				if(j - customer[i] >= 0 && dp[j - customer[i]] > 0) {
					if(dp[j] == 0)
						dp[j] = dp[j - customer[i]] + cost[i];
					else
						dp[j] = Math.min(dp[j], dp[j - customer[i]] + cost[i]); 
				}
						
				if(j >= C && dp[j] != 0) {
					answer = Math.min(answer, dp[j]);
				}
			}
		}
		
		System.out.println(answer);
	}

}

// dp[5] = 3, dp[10] = 6, dp[15] = 9, ...
// dp[6] = 4, dp[7] = 5, ... dp[12] = 8
