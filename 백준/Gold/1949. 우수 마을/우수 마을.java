import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<List<Integer>> adj = new ArrayList<>();
	static boolean[] vis;
 	static int[] humans;
 	static int[][] dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		humans = new int[N + 1];
		dp = new int[N + 1][2];
		vis = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			humans[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		dfs(1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}
	
	static void dfs(int cur) {
		vis[cur] = true;
				
		dp[cur][0] = 0;
		dp[cur][1] = humans[cur];
		
		for(int nxt : adj.get(cur)) {
			if(vis[nxt]) continue;
			
			
			dfs(nxt);
			
			dp[cur][0] += Math.max(dp[nxt][0], dp[nxt][1]);
			dp[cur][1] += dp[nxt][0];
		}
	}
	

}

// 5 2 4
// 1 4 3 2 1