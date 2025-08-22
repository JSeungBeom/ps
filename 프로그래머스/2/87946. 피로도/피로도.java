import java.util.*;

class Solution {
    
    static int[] arr;
    static boolean[] vis;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {        
        int n = dungeons.length;
        
        arr = new int[n];
        vis = new boolean[n];
        
        perm(0, n, k, dungeons);
        
        
        return answer;
    }
    
    static void perm(int n, int k, int rest, int[][] dungeons) {
        if(n == k) {
            explore(k, rest, dungeons);
            return;
        }
        
        for(int i = 0; i < k; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            arr[n] = i;
            perm(n + 1, k, rest, dungeons);
            vis[i] = false;
        }
    }
    
    static void explore(int n, int rest, int[][] dungeons) {
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            int min = dungeons[arr[i]][0];
            int consume = dungeons[arr[i]][1];
            
            if(rest >= min) {
                rest -= consume;
                cnt++;
            }
        }
        
        answer = Math.max(cnt, answer);
    }
}