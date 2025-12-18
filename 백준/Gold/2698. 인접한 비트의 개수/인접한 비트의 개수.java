import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static int n, k;
	static int[][][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        dp = new int[105][105][2];
        
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        
        for(int i = 2; i <= 100; i++) {
        	for(int j = 0; j <= 100; j++) {
        		if(j == 0)
        			dp[i][j][1] = dp[i - 1][j][0];
        		else
            		dp[i][j][1] = dp[i - 1][j - 1][1] + dp[i - 1][j][0];

        		dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
        	}
        }
        
        for(int i = 0; i < T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	n = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	
        	System.out.println(dp[n][k][0] + dp[n][k][1]);
        }
    }
   

}

