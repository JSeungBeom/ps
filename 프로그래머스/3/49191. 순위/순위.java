import java.util.*;

class Solution {
    
    static List<List<Integer>> adj = new ArrayList<>();
    static List<List<Integer>> rev_adj = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[] vis;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            rev_adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < results.length; i++) {
            adj.get(results[i][0]).add(results[i][1]);
            rev_adj.get(results[i][1]).add(results[i][0]);
        }
           
        for(int i = 1; i <= n; i++) {
            vis = new boolean[n + 1];
            boolean flag = true;
            
            bfs(i, adj);

            bfs(i, rev_adj);
            
            for(int j = 1; j <= n; j++) {
                if(!vis[j]){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
    
    static void bfs(int st, List<List<Integer>> list) {
        vis[st] = true;
        q.offer(st);
        
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int nxt : list.get(cur)) {
                if(vis[nxt]) continue;
                
                vis[nxt] = true;
                q.offer(nxt);
            }
        }
    }
}