import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	
	static int D, K;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < K; i++) {
			dp = new int[D + 1];
			dp[0] = K;
			dp[1] = i;
			
			boolean isContinuable = true;
			for(int j = 2; j < D; j++) {
				dp[j] = dp[j - 2] - dp[j - 1];
				
			
				if(dp[j] <= 0) {
					isContinuable = false;
					break;
				}
				
			}
			
			if(!isContinuable || dp[D - 1] > dp[D - 2]) continue;
			
			
			if(dp[D - 3] - (dp[D - 2] + dp[D - 1]) == 0) {
				System.out.println(dp[D - 1]);
				System.out.println(dp[D - 2]);
				
				break;
			}
		}
	}

}