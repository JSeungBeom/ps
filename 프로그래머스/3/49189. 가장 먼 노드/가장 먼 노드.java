import java.util.*;

class Solution {
    
    static List<List<Integer>> adj = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] dist;
    static int mx;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dist = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        
        Arrays.fill(dist, -1);
        
        q.offer(1);
        dist[1] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if(dist[cur] > mx) {
                mx = dist[cur];
                answer = 0;
            }
            
            answer++;
            
            for(int nxt : adj.get(cur)){
                if(dist[nxt] >= 0) continue;
                
                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }
        
        return answer;
    }
}