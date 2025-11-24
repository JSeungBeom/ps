import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static int N;
	static long[][] dp = new long[32][32];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	dp[1][0] = 1;
    	dp[2][0] = 2;
    	dp[3][0] = 5;
    	
    	solve(30, 0);

    	while(true) {
    		N = Integer.parseInt(br.readLine());
    		
    		if(N == 0) break;
    		
    		System.out.println(dp[N][0]);
    	}
    	
    }
    
    static long solve(int one, int half) {
    	if(one == 0) return 1;
    	
    	if(dp[one][half] != 0) {
    		return dp[one][half];
    	}
    	
    	long cnt = 0;
    	
    	if(one != 0) {
    		cnt += solve(one - 1, half + 1);
    	}
    	
    	if(half != 0) {
    		cnt += solve(one, half - 1);
    	}
    	
    	return dp[one][half] = cnt;
    }

}

// WH

// W HWH
// W WHH

// W WWHHH

// WH WWHH
// WH WHWH

// WW HWHH
// 3WW HHWH
