class Solution {
    
    static int[][] board;
    static int[][] dp;
    static final int DIV = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {        
        board = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        
        int len = puddles.length;
        
        for(int i = 0; i < len; i++) {
            board[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(board[i][j] == -1) continue;
                
                if(board[i - 1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % DIV;
                if(board[i][j - 1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % DIV;
            }
        }
        
        return dp[n][m] % DIV;
    }
}