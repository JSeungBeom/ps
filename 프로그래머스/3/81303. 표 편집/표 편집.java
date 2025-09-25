import java.util.*;

class Solution {
    
    static int[] nxt, prev;
    static boolean[] deleted;
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public String solution(int n, int k, String[] cmd) {        
        nxt = new int[n + 1];
        prev = new int[n + 1];
        deleted = new boolean[n + 1];
        
        for(int i = 0; i < n; i++) {
            nxt[i] = i + 1;
            prev[i] = i - 1;
        }
        
        int cur = k;
        int X = 0;
        
        for(int i = 0; i < cmd.length; i++) {
            String[] commands = cmd[i].split(" ");
            
            
            switch(commands[0]) {
                case "U" :
                    X = Integer.parseInt(commands[1]);
                    
                    for(int j = 0; j < X; j++) {                        
                        cur = prev[cur];
                    }
                    
                    break;
                case "D" :
                    X = Integer.parseInt(commands[1]);
                    
                    for(int j = 0; j < X; j++) {                        
                        cur = nxt[cur];
                    }
                    
                    break;
                case "C" :
                    deleted[cur] = true;
                    stack.push(cur);
                    
                    if(prev[cur] != -1)
                        nxt[prev[cur]] = nxt[cur];
                    
                    if(nxt[cur] != n)
                        prev[nxt[cur]] = prev[cur];
                    
                    if(nxt[cur] != n)
                        cur = nxt[cur];
                    else
                        cur = prev[cur];
                    
                    break;
                case "Z" :
                    int lastDeleted = stack.poll();
                    
                    deleted[lastDeleted] = false;
                    
                    if(prev[lastDeleted] != -1)
                        nxt[prev[lastDeleted]] = lastDeleted;
                    if(nxt[lastDeleted] != n)
                        prev[nxt[lastDeleted]] = lastDeleted;
                    break;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(deleted[i] == true ? 'X' : 'O');
        }
        
        return sb.toString();
    }
}