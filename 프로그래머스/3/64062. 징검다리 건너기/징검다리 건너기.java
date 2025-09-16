import java.util.*;

class Solution {    
    public int solution(int[] stones, int k) {        
        int st = 0;
        int en = 200000000;
        
        while(st < en) {
            int mid = (st + en + 1) / 2;
            
            if(solve(mid, stones, k)) st = mid;
            else en = mid - 1;
        }
        
        return st;
    }
    
    static boolean solve(int mid, int[] stones, int k) {
        int cnt = 0;
        
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] - mid < 0) {
                cnt++;        
            }
            else{
                cnt = 0;
            }
            
            if(cnt == k) return false;
        }
        
        return true;
    }
}