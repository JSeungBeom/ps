import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<List<int[]>> adj = new ArrayList<>();
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
	static int[] dist;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj.get(a).add(new int[] { b, c });
			adj.get(b).add(new int[] { a, c });
		}
		
		dist = new int[N + 1];
		
		Arrays.fill(dist, MAX);
		
		dist[1] = 0;
		
		pq.add(new int[] {dist[1], 1});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[1];
			int cost = cur[0];
			
			if(dist[now] < cost) continue;
			
			for(int[] nxt : adj.get(now)) {
				if(dist[nxt[0]] > dist[now] + nxt[1]) {
					dist[nxt[0]] = dist[now] + nxt[1];
					pq.add(new int[] {dist[nxt[0]], nxt[0]});
				}
			}
		}
		
		System.out.println(dist[N]);
	}
	
}