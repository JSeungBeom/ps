import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int T, k;
	static int[][] coins;
	static int[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        dp = new int[k + 1][T + 1];
        coins = new int[k + 1][2];
        
        for(int i = 0; i < k; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int coin = Integer.parseInt(st.nextToken()); 
        	int num = Integer.parseInt(st.nextToken());
        	
        	coins[i][0] = coin;
        	coins[i][1] = num;
        }
        
        for(int i = 0; i <= k; i++)
        	Arrays.fill(dp[i], -1);
        	
        System.out.println(solve(0, 0));
    }
    
    static int solve(int total, int cur) {
    	if(total == T)
    		return 1;
    	
    	if(cur > k || total > T) return 0;
    	
    	if(dp[cur][total] >= 0) return dp[cur][total];
    	
    	int coin = coins[cur][0];
    	int num = coins[cur][1];
    	int res = 0;
    	
    	for(int i = 0; i <= num; i++) {
    		res += solve(total + coin * i, cur + 1);
    	}
    	
    	return dp[cur][total] = res;
    }
}
