import java.util.*;

class Solution {
    
    static int[][] dist;
    static final int INF = 100_000_0;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        dist = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        
        for(int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int c = fares[i][2];
            
            dist[u][v] = c;
            dist[v][u] = c;
        }
        
        for(int mid = 1; mid <= n; mid++) {
            for(int st = 1; st <= n; st++) {
                for(int en = 1; en <= n; en++) {
                    dist[st][en] = Math.min(dist[st][en], dist[st][mid] + dist[mid][en]);
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int sum = dist[s][i];
            
            sum += dist[i][a];
            sum += dist[i][b];
            
            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
}