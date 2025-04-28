import java.util.*;

class Solution {
    static int[][] dp;

    public int solution(int sticker[]) {
        int n = sticker.length;
        
        
        if(n == 1)
            return sticker[0];
        else if(n == 2)
            return Math.max(sticker[0], sticker[1]);
        
        dp = new int[n][2];
    
        dp[0][0] = sticker[0];
        dp[1][0] = sticker[0];
        
        
        dp[1][1] = sticker[1];
        dp[2][1] = sticker[1];
        
        
        for(int i = 2; i < n - 1; i++){ 
            dp[i][0] = Math.max(dp[i - 2][0] + sticker[i], dp[i - 1][0]);
        }
        
        for(int i = 2; i < n; i++){
            dp[i][1] = Math.max(dp[i - 2][1] + sticker[i] , dp[i - 1][1]);
        }

        
    
        return Math.max(dp[n - 2][0], dp[n - 1][1]);
    }
}