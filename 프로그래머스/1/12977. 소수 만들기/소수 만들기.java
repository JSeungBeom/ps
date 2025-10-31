class Solution {
    static int answer;
    static boolean[] vis;
    static int[] arr;
    
    public int solution(int[] nums) {
        vis = new boolean[nums.length];
        arr = new int[3];
        
        perm(0, 3, 0, nums);
        
        
        return answer;
    }
    
    static void perm(int n, int k, int st, int[] nums) {
        if(n == k) {
            int num = 0;
            
            for(int i = 0; i < n; i++) {
                num += nums[arr[i]];
            }
            
            if(isPrime(num)) answer++;
            
            return;
        }
        
        for(int i = st; i < nums.length; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            arr[n] = i;
            perm(n + 1, k, i, nums);
            vis[i] = false;
        }
    }
    
    static boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}