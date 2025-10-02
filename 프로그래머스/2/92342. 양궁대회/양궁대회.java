import java.util.*;

class Solution {
    
    static int[] arr;
    static int max;
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        
        arr = new int[n];
                
        perm(0, n, 10, info, answer);
        
        System.out.println(max);
        
        for(int i = 0; i < 10; i++) {
            if(answer[i] != 0) return answer; 
        }
        
        return new int[] {-1};
    }
    
    static void perm(int n, int k, int st, int[] info, int[] answer) {
        if(n == k) {
            int lion = 0, apeach = 0;
            int[] cnt = new int[11];

            for(int i = 0; i < k; i++) {
                cnt[arr[i]]++;
            }            
            
            for(int i = 0; i <= 10; i++) {
                if(info[i] < cnt[i]) {
                    lion += (10 - i);
                }
                else {
                    if(info[i] > 0)
                        apeach += (10 - i);
                }
            }
            
                        
            if(max < lion - apeach) {
                for(int i = 0; i <= 10; i++) {
                    answer[i] = cnt[i];
                }
                
                max = lion - apeach;
            }
            
            return;
        }
        
        for(int i = st; i >= 0; i--) {            
            arr[n] = i;
            perm(n + 1, k, i, info, answer);
        }
    } 
}
