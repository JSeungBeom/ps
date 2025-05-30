import java.util.*;

class Solution {
    
    static List<List<Integer>> adj = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dist = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        
        bfs(destination);

        for(int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        
        return answer;
    }
    
    static void bfs(int dst) {
        Arrays.fill(dist, -1);
        
        q.offer(dst);
        dist[dst] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
                        
            for(int nxt : adj.get(cur)) {
                if(dist[nxt] >= 0) continue;
                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }
    }
}