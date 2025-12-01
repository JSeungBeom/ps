import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, A, B;
	static int[] closet;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	
    	M = Integer.parseInt(br.readLine());
    	
    	closet = new int[M + 1];
    	dp = new int[M + 1][N + 1][N + 1];
    	
    	for(int i = 1; i <= M; i++) {
    		closet[i] = Integer.parseInt(br.readLine());
    	}
    	
    	
    	
    	for(int i = 1; i <= M; i++) {
    		for(int j = 1; j <= N; j++) {
    			Arrays.fill(dp[i][j], -1);
    		}
    	}
    	
    	System.out.println(solve(1, A, B));
    }
	
	static int solve(int k, int a, int b) {
		if(k > M) return 0;
		
		if(dp[k][a][b] != -1) return dp[k][a][b];
		
		int target = closet[k];
		
		if(target == a || target == b) {
			dp[k][a][b] = solve(k + 1, a, b);
		} else {
			int costA = Math.abs(target - a) + solve(k + 1, target, b);
			int costB = Math.abs(target - b) + solve(k + 1, a, target);
			
			dp[k][a][b] = Math.min(costA, costB);
		}
		
		return dp[k][a][b];
	}
	

}