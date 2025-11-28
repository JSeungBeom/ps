import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int T, N;
	static long[][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	T = Integer.parseInt(br.readLine());
    	
		dp = new long[65][10];
	
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 1; i <= 64; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k >= 0; k--) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
    	
    	for(int i = 0; i < T; i++) {
    		N = Integer.parseInt(br.readLine());
    		
    		long answer = 0;
    		
    		for(int j = 0; j < 10; j++) {
    			answer += dp[N][j];
    		}
    		
    		System.out.println(answer);
    	}
    	
    	
    }


    
    

}