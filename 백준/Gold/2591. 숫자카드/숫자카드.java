import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static String S;
	static int[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = br.readLine();
        
        dp = new int[S.length()][35];
        
        for(int i = 0; i < S.length(); i++)
        	Arrays.fill(dp[i], -1);
        
        System.out.println(solve(0, 0));
//        
//        for(int i = 0; i < S.length(); i++) {
//        	for(int j = 0; j < 35; j++) {
//        		System.out.print(dp[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
    }
    
    static int solve(int idx, int cur) {
    	if(idx == S.length())
    		return 1;
    	
    	if(dp[idx][cur] >= 0)
    		return dp[idx][cur];
    	
    	int num = 0;
    	int res = 0;
    	
    	for(int i = idx; i < S.length(); i++) {
    		int now = (int)(S.charAt(i) - '0');
    		    		
    		num = num * 10 + now;
    		
    		if(num > 34 || num == 0) break;
    		
    		res += solve(i + 1, num);
    	}
    	
    	return dp[idx][cur] = res;
    }
   
}

