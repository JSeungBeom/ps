import java.util.*;

class Solution {
    
    static boolean[][] matrix;
    static boolean[] vis;
    static Queue<Integer> q = new ArrayDeque<>();
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        matrix = new boolean[n + 1][n + 1];

        
        for(int i = 0; i < n - 1; i++) {
            matrix[wires[i][0]][wires[i][1]] = true;
            matrix[wires[i][1]][wires[i][0]] = true;
        }
        
        
        for(int i = 0; i < n - 1; i++) {
            matrix[wires[i][0]][wires[i][1]] = false;
            matrix[wires[i][1]][wires[i][0]] = false;
            vis = new boolean[n + 1];
            int cnt1 = 0;
            int cnt2 = 0;
            
            boolean visited = false;
            
            for(int j = 1; j <= n; j++) {
                if(vis[j]) continue;
                
                vis[j] = true;
                q.offer(j);
                
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    if(visited) cnt1++;
                    else cnt2++; 
                    
                    for(int k = 1; k <= n; k++) {
                        if(matrix[cur][k]) {
                            if(!vis[k]) {
                                q.offer(k);
                                vis[k] = true;
                            }
                        }
                    }
                }
                
                visited = true;
                        
            }
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            
            matrix[wires[i][0]][wires[i][1]] = true;
            matrix[wires[i][1]][wires[i][0]] = true;
        }
        
        
        return answer;
    }
}