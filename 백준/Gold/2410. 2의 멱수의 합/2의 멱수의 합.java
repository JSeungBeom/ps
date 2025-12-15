import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] dp;
	static final int div = 1_000_000_000;
	static int answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N + 1];

        dp[0] = 1;
        
        for(int i = 1; i <= N; i <<= 1) {
        	for(int j = i; j <= N; j++) {
        		dp[j] = ((dp[j] + dp[j - i]) % div);
        	}
        }
        
        
        System.out.println(dp[N]);
        
    }
    

    
}
