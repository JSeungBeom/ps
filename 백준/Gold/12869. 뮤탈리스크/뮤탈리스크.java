import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] SCV;
	static int[][] mutal = new int[][] {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
	static int[][][] dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		SCV = new int[3];
		dp = new int[61][61][61];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			SCV[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(solve(SCV[0], SCV[1], SCV[2]));
	}
	
	static int solve(int a, int b, int c) {
		if(a < 0) return solve(0, b, c);
		
		if(b < 0) return solve(a, 0, c);
		
		if(c < 0) return solve(a, b, 0);
		
		if(dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
			
		
		if(a <= 0 && b <= 0 && c <= 0) {
			return 0;
		}
	
		dp[a][b][c] = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			dp[a][b][c] = Math.min(dp[a][b][c], solve(a - mutal[i][0], b - mutal[i][1], c - mutal[i][2]) + 1);
		}
		
		return dp[a][b][c];
	}
	

}
