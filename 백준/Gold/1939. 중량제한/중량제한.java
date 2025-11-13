import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int A, B, C;
	static int start, end;
	static List<List<int[]>> adj = new ArrayList<>();
	static int[] dist;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[N + 1];
        
        for(int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	adj.get(A).add(new int[] {B, C});
        	adj.get(B).add(new int[] {A, C});
        }
        
        st = new StringTokenizer(br.readLine());
        
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= N; i++) {
        	dist[i] = 0;
        }
        
        dist[start] = Integer.MAX_VALUE;
        
    	pq.offer(new int[] {start, dist[start]});
        
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	
        	int node = cur[0];
        	int limit = cur[1];

        	if(dist[node] != limit) continue;
        	
        	for(int[] nxt : adj.get(node)) {
        		int newLimit = Math.min(limit, nxt[1]);
        		
        		if(newLimit > dist[nxt[0]]) {
        			dist[nxt[0]] = newLimit;
            		pq.offer(new int[] {nxt[0], dist[nxt[0]]});
        		}
        	}
        }

        
        System.out.println(dist[end]);
        
    }

}
