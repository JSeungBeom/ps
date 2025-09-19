class Solution {
    
    static boolean[][] greater;
    
    public int solution(int[] a) {
        int answer = 0;
        
        int cur = Integer.MAX_VALUE;
        
        for(int i = 0; i < a.length; i++) {
            if(cur > a[i]) {
                answer++;
            }
            
            cur = Math.min(cur, a[i]);
        }
        
        cur = Integer.MAX_VALUE;
        
        for(int i = a.length - 1; i >= 0; i--) {
            if(cur > a[i]) {
                answer++;
            }
            
            cur = Math.min(cur, a[i]);
        }
        
        return answer - 1;
    }
}

// 9 -1 -5

// 1 2 3 2 1