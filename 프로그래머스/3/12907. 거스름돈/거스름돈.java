import java.util.*;

class Solution {
    
    static int[] dp;
    
    public int solution(int n, int[] money) {
        int answer = 0;
        
        dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 0; i < money.length; i++) {
            int cur = money[i];
            
            for(int j = cur; j <= n; j++) {
                dp[j] += dp[j - cur];
                dp[j] %= 1000000007;
            }
        }
        
        return dp[n];
    }
}

// 1
// 1 1, 2
// 1 1 1, 1 2
// 1 1 1 1, 1 1 2, 2 2
// 1 1 1 1 1, 1 1 1 2, 2 2 1, 5