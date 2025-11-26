import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static long[] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    	N = Integer.parseInt(br.readLine());

    	if(N == 1) {
    		System.out.println(1); return;
    	}
    	
    	if(N == 2) {
    		System.out.println(2); return;
    	}
    	
    	dp = new long[N + 1];
    	
    	dp[1] = 1;
    	dp[2] = 2;
    	
    	for(int i = 3; i <= N; i++) {
    		dp[i] = dp[i - 1] + 1;
    		for(int j = 1; j <= i - 2; j++) {
    			dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
    		}
    		
    	}

    	
    	System.out.println(dp[N]);
    }
}