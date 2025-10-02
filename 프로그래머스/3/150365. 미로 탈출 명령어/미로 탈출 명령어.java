import java.util.*;

class Solution {
    
    static int n, m, x, y, r, c, k;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] path = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;
        
        StringBuilder sb = new StringBuilder();
        
        return dfs(x, y, sb) == true ? sb.toString() : "impossible"; 
    }
    
    static boolean dfs(int x, int y, StringBuilder sb) {
        if(sb.length() == k) {
            return x == r && y == c;
        }
        
        int remain = k - sb.length(); // 남은 횟수 (갈 수 있는 거리)
        int distance = Math.abs(x - r) + Math.abs(y - c); // 도착점까지 거리
        
        if(remain < distance || (remain - distance) % 2 != 0) return false;
        
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
            
            sb.append(path[dir]);
            if(dfs(nx, ny, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return false;
    }
}