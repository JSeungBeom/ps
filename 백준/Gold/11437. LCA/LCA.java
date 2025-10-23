import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<List<Integer>> adj = new ArrayList<>();
	static int[] parent;
	static boolean[] vis;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		
		vis = new boolean[N + 1];
		parent = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj.get(v).add(u);
			adj.get(u).add(v);
		}
		
		makeTree(1);
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			vis = new boolean[N + 1];

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			findParent(u);
			
			System.out.println(findCommonParent(v));
		}
	}
	
	static void makeTree(int cur) {
		vis[cur] = true;
		
		for(int nxt : adj.get(cur)) {
			if(vis[nxt]) continue;
				
			parent[nxt] = cur;
			makeTree(nxt);
		}
	}
	
	static void findParent(int cur) {
		if(parent[cur] == 0) return;
		
		vis[cur] = true;
		
		findParent(parent[cur]);
	}
	
	static int findCommonParent(int cur) {
		if(parent[cur] == 0) return 1;
		if(vis[cur]) return cur;
		
		return findCommonParent(parent[cur]);
	}
	

}

// 5 2 4
// 1 4 3 2 1