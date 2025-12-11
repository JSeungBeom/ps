import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int t, n;
	static int x, y;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
        	n = Integer.parseInt(br.readLine());
    
        	List<int[]> nodes = new ArrayList<>();
        	List<List<Integer>> adj = new ArrayList<>();
        	
        	for(int j = 0; j < n + 2; j++) 
        		adj.add(new ArrayList<>());
        	
        	for(int j = 0; j < n + 2; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		x = Integer.parseInt(st.nextToken());
        		y = Integer.parseInt(st.nextToken());
        		
        		nodes.add(new int[] {x, y});
        	}
        	
        	for(int j = 0; j < n + 1; j++) {
        		for(int k = j + 1; k < n + 2; k++) {
        			if(reachable(nodes.get(j), nodes.get(k))) {
        				adj.get(j).add(k);
        				adj.get(k).add(j);
        			}
        		}
        	}
        	
        	if(bfs(adj)) System.out.println("happy");
        	else System.out.println("sad");
        }
        
        
    }
    
    static boolean reachable(int[] pos1, int[] pos2) {
    	return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]) <= 1000;
    }
    
    static boolean bfs(List<List<Integer>> adj) {
    	Queue<Integer> queue = new ArrayDeque<>();
    	boolean[] vis = new boolean[n + 2];
    	
    	queue.add(0);
    	vis[0] = true;

    	while(!queue.isEmpty()) {
    		int cur = queue.poll();
    		
    		for(int nxt : adj.get(cur)) {
    			if(vis[nxt]) continue;
    			
    			queue.add(nxt);
    			vis[nxt] = true;
    		}
    	}
    	
    	if(vis[n + 1]) return true;
    	
    	return false;
    }
}