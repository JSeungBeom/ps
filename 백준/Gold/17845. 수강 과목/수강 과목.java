import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] I, T;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	I = new int[K + 1];
    	T = new int[K + 1];
    	
    	dp = new long[K + 1][N + 1];
    	
    	for(int i = 1; i <= K; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		I[i] = Integer.parseInt(st.nextToken());
    		T[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 1; i <= K; i++) {
    		for(int j = 1; j <= N; j++) {
    			dp[i][j] = dp[i - 1][j];
    			
    			if(j - T[i] >= 0) 
    				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - T[i]] + I[i]);
    			
    		}
    	}
    	
    	System.out.println(dp[K][N]);
    	
    }
	
}