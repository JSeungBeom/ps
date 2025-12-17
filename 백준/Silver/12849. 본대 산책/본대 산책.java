import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int D;
	static List<List<Integer>> adj = new ArrayList<>();
	static int[][] dp;
	static final int DIV = 1_000_000_007;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        D = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= 8; i++) 
        	adj.add(new ArrayList<>());
        
        init();
        
        dp = new int[8][D + 1];
        
        for(int i = 0; i < 8; i++)
        	Arrays.fill(dp[i], -1);

        System.out.println(solve(0, 0));
    }
    
    static int solve(int cur, int time) {
    	if(cur >= 8 || time > D) return 0;
    	
    	if(cur == 0 && time == D)
    		return 1;
    	
    	if(dp[cur][time] >= 0) 
    		return dp[cur][time];
    	
    	int res = 0;
    	
    	for(int nxt : adj.get(cur)) {
    		res = (res + solve(nxt, time + 1)) % DIV;
    	}
    	
    	return dp[cur][time] = res;
    }
    
    static void init() {
    	connect(0, 1);
    	connect(0, 2);
    	connect(1, 2);
    	connect(2, 3);
    	connect(1, 3);
    	connect(3, 4);
    	connect(2, 4);
    	connect(4, 5);
    	connect(3, 5);
    	connect(5, 6);
    	connect(6, 7);
    	connect(4, 7);
    }
    
    static void connect(int x, int y) {
    	adj.get(x).add(y);
    	adj.get(y).add(x);
    }
}

