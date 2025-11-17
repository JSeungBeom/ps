import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> list = new ArrayList<>();
	static int[][][] dp;
	static int N, answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	list.add(-1);
    	
    	while(true) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		if(num == 0) break;
    		
    		list.add(num);
    	}
    	
    	N = list.size() - 1;
    	
    	dp = new int[N + 1][5][5];
    	
    	for(int i = 0; i <= N; i++) {
    		for(int j = 0; j < 5; j++) {
    			Arrays.fill(dp[i][j], Integer.MAX_VALUE);
    		}
    	}
    	
    	dp[0][0][0] = 0;
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 0; j <= 4; j++) {
    			for(int k = 0; k <= 4; k++) {
    				if(dp[i - 1][j][k] != Integer.MAX_VALUE) {
    					int target = list.get(i);
    					
    					dp[i][target][k] = Math.min(dp[i][target][k], dp[i - 1][j][k] + getCost(j, target));
    					dp[i][j][target] = Math.min(dp[i][j][target], dp[i - 1][j][k] + getCost(k, target));
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i <= 4; i++) {
    		for(int j = 0; j <= 4; j++) {
				answer = Math.min(answer, dp[N][i][j]);
    		}
    	}
    	
    	System.out.println(answer);
    }
    
    static int getCost(int cur, int target) {
    	if(cur == 0) return 2;
    	if(cur == target) return 1;
    	
    	switch(cur) {
    		case 1 :
    		case 3 :
    			if(target == 2 || target == 4) return 3;
    			return 4;
    			
    		case 2 :
    		case 4 :
    			if(target == 1 || target == 3) return 3;
    			return 4;
    	}
    	
    	return 0;
    }

}
