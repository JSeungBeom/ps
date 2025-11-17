import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int[][] dp;
	static int answer = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	arr = new int[N + 1];
    	dp = new int[N + 1][2];
    	
    	for(int i = 1; i <= N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp[0][0] = -1005;
    	
    	for(int i = 1; i <= N; i++) {
    		dp[i][0] = arr[i];
    		
    		dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + arr[i]);
    		dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
    		
    		
    		answer = Math.max(Math.max(answer, dp[i][0]), dp[i][1]);
    	}
    	
    	System.out.println(answer);
    }

}
