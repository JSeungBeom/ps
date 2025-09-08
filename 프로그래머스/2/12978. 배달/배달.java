import java.util.*;

class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static List<List<int[]>> adj = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        dist = new int[N + 1];
        
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int c = road[i][2];
            
            adj.get(u).add(new int[] {v, c});
            adj.get(v).add(new int[] {u, c});
        }
        
        for(int i = 1; i <= N; i++) {
            dist[i] = MAX; 
        }
        
        dist[1] = 0;

        pq.offer(new int[] {1, dist[1]});
        
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            
            int cur = arr[0];
            int cost = arr[1];
            
            if(cost > dist[cur]) continue;
            
            for(int[] nxt : adj.get(cur)) {
                if(dist[nxt[0]] >= nxt[1] + cost) {
                    dist[nxt[0]] = nxt[1] + cost;
                    pq.offer(new int[] {nxt[0], dist[nxt[0]]});
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}