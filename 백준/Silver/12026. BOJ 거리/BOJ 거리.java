import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static char[] road;
	static int[][] dp;
	static final int INF = 1_000_000_000;
	static char[] arr = new char[] {'B', 'O', 'J'};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        road = br.readLine().toCharArray();
        
        dp = new int[N][3];
        
        for(int i = 0; i < N; i++)
        	Arrays.fill(dp[i], -1);
        
        int answer = solve(0, 1);
        
        System.out.println(answer >= INF ? -1 : answer);
        
    }
    
    static int solve(int idx, int order) {
    	if(idx >= N - 1)
    		return 0;
    	
    	if(dp[idx][order] >= 0)
    		return dp[idx][order];
    	
    	int res = INF;
    	
    	for(int i = idx + 1; i < N; i++) {
    		int jump = i - idx;
    		
    		if(road[i] == arr[order]) 
    			res = Math.min(res, solve(i, (order + 1) % 3) + (jump * jump));
    	}
    	
    	return dp[idx][order] = res;
    }

    
}