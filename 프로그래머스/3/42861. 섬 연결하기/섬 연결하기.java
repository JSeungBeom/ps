import java.util.*;

class Solution {
    
    static List<int[]> edges = new ArrayList<>();
    static int[] p;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        p = new int[n];
        
        for(int i = 0; i < n; i++) {
            p[i] = i;    
        }
        
        int e = costs.length;
        
        for(int i = 0; i < e; i++) {
            edges.add(new int[] {costs[i][2], costs[i][0], costs[i][1]});
        }
        
        Collections.sort(edges, (e1, e2) -> e1[0] - e2[0]);
        
        int cnt = 0;
        
        for(int i = 0; i < e; i++) {
            int[] cur = edges.get(i);
            
            int c = cur[0];
            int u = cur[1];
            int v = cur[2];
            
            if(union(u, v)) {
                answer += c;
                cnt++;
            }
            
            if(cnt == n - 1) break;
        }
        
        return answer;
    }
    
    static int findParent(int x) {
        if(p[x] == x) return x;
        return p[x] = findParent(p[x]);
    }
    
    static boolean union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);
        
        if(px < py) p[py] = px;
        else if(px > py) p[px] = py;
        else return false;
        
        return true;
    }
}