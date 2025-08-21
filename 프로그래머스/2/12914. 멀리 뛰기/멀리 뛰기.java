class Solution {
    
    static int[] dp;
    
    public long solution(int n) {
        long answer = 0;
        
        dp = new int[n + 1];
        
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}