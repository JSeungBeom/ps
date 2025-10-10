class Solution {
    
    static int MOD = 20170805;
    static long[][][] dp;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
   
        dp = new long[m][n][2];
        
        if(m > 1) dp[1][0][1] = 1;
        if(n > 1) dp[0][1][0] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(cityMap[i][j] == 1) continue;
                
                if(i + 1 < m) {
                    dp[i + 1][j][1] += 
                        (dp[i][j][1] + (cityMap[i][j] == 0 ? dp[i][j][0] : 0)) % MOD;
                }
                
                if(j + 1 < n) {
                    dp[i][j + 1][0] += 
                        (dp[i][j][0] + (cityMap[i][j] == 0 ? dp[i][j][1] : 0)) % MOD;
                }
            }
        }
        

        
        return (int) ((dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD);
    }
}