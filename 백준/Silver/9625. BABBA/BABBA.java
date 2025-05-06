import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int K;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		dp = new int[K + 1][2];
		
		dp[0][0] = 1; // A 개수
		dp[1][0] = 0; // B 개수
		
		for(int i = 1; i <= K; i++) {
			dp[i][0] = dp[i - 1][1]; // A 개수는 B 개수만큼 증가
			dp[i][1] = dp[i - 1][0] + dp[i - 1][1]; // B 개수는 A + B 개수만큼 증가
		}
		
		System.out.println(dp[K][0] + " " + dp[K][1]);
	}
	
}

// A -> BA -> BAB -> BABBA -> ...
// A -> B
// B -> BA
