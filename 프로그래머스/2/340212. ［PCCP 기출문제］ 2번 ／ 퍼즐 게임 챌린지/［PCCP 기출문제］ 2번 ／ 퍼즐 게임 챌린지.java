class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int st = 1;
        int en = 100000;
        
        while(st < en) {
            int mid = (st + en) / 2;
            
            if(solve(mid, diffs, times, limit)) en = mid;
            else st = mid + 1;
        }
        
        return st;
    }
    
    static boolean solve(int level, int[] diffs, int[] times, long limit) {
        long sum = times[0];
        
        for(int i = 1; i < diffs.length; i++) {
            if(diffs[i] <= level)
                sum += times[i];
            else
                sum += ((times[i] + times[i - 1]) * (diffs[i] - level)) + times[i];                
        }
        
        return sum <= limit;
    }
}