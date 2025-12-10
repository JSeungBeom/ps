import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static String S;
	static String[] bridge = new String[2];
	static int[][][] dp;
	static int sLen, bridgeLen;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = br.readLine();
        
        bridge[0] = br.readLine();
        bridge[1] = br.readLine();
        
        bridgeLen = bridge[0].length();
        sLen = S.length();
        
        dp = new int[2][bridgeLen][sLen];
        
        int answer1 = solve(0, 0, 0);
        int answer2 = solve(1, 0, 0);

        
        System.out.println(answer1 + answer2);
    }
    
    static int solve(int bridgeType, int cur, int len) {
    	if(len == sLen) {
    		return 1;
    	}
    	
    	if(cur >= bridgeLen || len >= S.length()) {
    		return 0;
    	}
    	
    	
    	if(dp[bridgeType][cur][len] > 0) {
    		return dp[bridgeType][cur][len];
    	}
    	
    	int res = 0;
    	
    	for(int i = cur; i < bridgeLen; i++) {
    		if(bridge[bridgeType].charAt(i) == S.charAt(len)) {
    			res += solve(bridgeType ^ 1, i + 1, len + 1);
    		}
    	}
    	
    	return dp[bridgeType][cur][len] = res;
    }
}
