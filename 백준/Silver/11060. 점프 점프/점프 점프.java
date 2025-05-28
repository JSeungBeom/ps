import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N + 1];
		dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = 1005;
			
			for(int j = 1; j < i; j++) {
				if(arr[j] >= i - j) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		
		if(dp[N] == 1005) 
			System.out.println(-1);
		else
			System.out.println(dp[N]);
  	}
}