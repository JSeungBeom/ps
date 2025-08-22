class Solution {
    
    static long[] cntWeights;
    static long[] cntMuls;
    
    public long solution(int[] weights) {
        long answer = 0;
        
        int n = weights.length;
        
        cntWeights = new long[1005];
        cntMuls = new long[4005];
        
        for(int i = 0; i < n; i++) {
            int weight = weights[i];
            
            long cnt = cntWeights[weight];
            int m2 = weight * 2;
            int m3 = weight * 3;
            int m4 = weight * 4;
            
            answer += cnt;

            answer += cntMuls[m2] - cnt;
            answer += cntMuls[m3] - cnt;
            answer += cntMuls[m4] - cnt;
            
            cntWeights[weight]++;
            cntMuls[m2]++;
            cntMuls[m3]++;
            cntMuls[m4]++;
        }
        
        
        return answer;
    }
}