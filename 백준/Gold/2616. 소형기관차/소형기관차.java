import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] train;
	static int[] psum;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    	N = Integer.parseInt(br.readLine());
    	
    	train = new int[N + 1];
    	psum = new int[N + 1];
    	
    	dp = new int[4][N + 1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 1; i <= N; i++) {
    		train[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	K = Integer.parseInt(br.readLine());
    	
    	for(int i = 1; i <= N; i++) {
    		psum[i] = psum[i - 1] + train[i];
    	}
    	
    	for(int i = 1; i < 4; i++) {
    		for(int j = i * K; j <= N; j++) {
    			dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + psum[j] - psum[j - K]);
    		}
    	}
    	
    	System.out.println(dp[3][N]);
    
    }
    

}