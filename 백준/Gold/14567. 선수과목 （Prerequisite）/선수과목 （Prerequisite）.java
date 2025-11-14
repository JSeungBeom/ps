import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] indeg;
	static int[] answer;
	static List<List<Integer>> adj = new ArrayList<>();
	static Queue<Integer> queue = new ArrayDeque<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        indeg = new int[N + 1];
        answer = new int[N + 1];
        
        for(int i = 0; i <= N; i++) {
        	adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	adj.get(u).add(v);
        	indeg[v]++;
        }
        
        for(int i = 1; i <= N; i++) {
        	if(indeg[i] == 0) {
        		queue.offer(i);
        		answer[i] = 1;
        	}
        }
        
        while(!queue.isEmpty()) {
        	int cur = queue.poll();
        	
        	for(int nxt : adj.get(cur)) {
        		indeg[nxt]--;
        		
        		if(indeg[nxt] == 0) {
        			answer[nxt] = answer[cur] + 1;
        			queue.add(nxt);
        		}
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	System.out.print(answer[i] + " ");
        }
    }
    
}
