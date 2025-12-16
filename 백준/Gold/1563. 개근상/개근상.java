import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][][] dp;
	static final int MOD = 1_000_000;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N][2][3];
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < 2; j++) {
    			Arrays.fill(dp[i][j], -1);
        	}
        }
        
        int answer = solve(0, 0, 0);
        
        
        System.out.println(answer);
    }
    
    static int solve(int cur, int L, int A) {
    	if(L >= 2 || A >= 3)
    		return 0;
    	if(cur == N)
    		return 1;

    	if(dp[cur][L][A] >= 0)
    		return dp[cur][L][A];
    	
    	int res = 0;
    	
		res += solve(cur + 1, L, 0) % MOD;
		res += solve(cur + 1, L + 1, 0) % MOD;
		res += solve(cur + 1, L, A + 1) % MOD;
		
		
    	return dp[cur][L][A] = res % MOD;
    }
}

