import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] D, P;
	static int[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        D = new int[M + 1];
        P = new int[M + 1];
        
        dp = new int[M + 1][N + 1];
        
        for(int i = 1; i <= M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	D[i] = Integer.parseInt(st.nextToken());
        	P[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= M; i++) {
        	for(int j = 1; j <= N; j++) {
        		dp[i][j] = dp[i - 1][j];
        		
        		if(j - D[i] >= 0) {
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - D[i]] + P[i]);
        		}
        	}
        }
        
        
        System.out.println(dp[M][N]);
        
    }
    

   
}

