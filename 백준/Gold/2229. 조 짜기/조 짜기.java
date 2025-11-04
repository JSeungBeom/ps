import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N + 1];
		dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 0;
		
		for(int i = 1; i <= N; i++) {
			int max = arr[i];
			int min = arr[i];
			
			for(int j = i; j >= 1; j--) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				dp[i] = Math.max(dp[i], dp[j - 1] + max - min);
			}
			
		}
		
		System.out.println(dp[N]);
	}

}
