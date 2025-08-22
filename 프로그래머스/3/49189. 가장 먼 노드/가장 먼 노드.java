import java.util.*;

class Solution {
    
    static List<List<Integer>> adj = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>(); 
    static int[] dist;
    static int mx_dist;
    static int answer;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        
        dist = new int[n + 1];
        
        Arrays.fill(dist, -1);
        
        dist[1] = 0;
        
        q.offer(1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            mx_dist = Math.max(dist[cur], mx_dist);
            
            for(int nxt : adj.get(cur)) {
                if(dist[nxt] >= 0) continue;
                
                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(dist[i] == mx_dist) answer++;
        }
        
        return answer;
    }
}