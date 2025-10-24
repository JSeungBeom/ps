import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] memory;
	static int[] cost;
	static int[][] dp;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memory = new int[N + 1];
		cost = new int[N + 1];
		dp = new int[N + 1][10005]; // dp[i][j] : 인덱스 i에서 j 비용의 최댓값
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= 10000; j++) {
				if(j - cost[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]); 
				}
				else
					dp[i][j] = dp[i - 1][j];
				
				if(dp[i][j] >= M) {
					answer = Math.min(answer, j);
				}
					
			}
		}
		
		System.out.println(answer);
	}
	

}
