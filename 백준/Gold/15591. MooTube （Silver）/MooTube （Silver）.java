import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, Q;
	static int[][] usado;
	static boolean[] vis;
	static Queue<Integer> q = new ArrayDeque<>();
	static List<List<int[]>> adj = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		usado = new int[N + 1][N + 1];
		
		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj.get(u).add(new int[] {v, c});
			adj.get(v).add(new int[] {u, c});
		}
		
		for(int i = 1; i <= N; i++) {
			vis = new boolean[N + 1];
			
			dfs(i, i, Integer.MAX_VALUE);
		}

		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			for(int j = 1; j <= N; j++) {
				if(usado[v][j] >= k) cnt++; 
			}
			
			System.out.println(cnt);
		}
		

	}
	
	static void dfs(int st, int cur, int min) {
		vis[cur] = true;
		
		for(int[] nxt : adj.get(cur)) {
			int nxtNode = nxt[0];
			int nxtDist = nxt[1];
			
			if(vis[nxtNode]) continue;
			
			usado[st][nxtNode] = Math.min(min, nxtDist);
			
			dfs(st, nxtNode, Math.min(min, nxtDist));
		}
	}

}