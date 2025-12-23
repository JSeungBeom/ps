import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i = 1, j = 5; i <= N; i += j, j += 4) {
        	for(int k = i; k <= N; k++) {
        		if(dp[k - i] != Integer.MAX_VALUE) {
        			dp[k] = Math.min(dp[k], dp[k - i] + 1);
        		}
        	}
        }
        
        System.out.println(dp[N]);
    }
    
}

