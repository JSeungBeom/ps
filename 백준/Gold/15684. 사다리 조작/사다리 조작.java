import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H;
	static boolean[][][] ladder;
	static List<int[]> candidates = new ArrayList<>();
	static int answer;
	static boolean isFinished;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new boolean[H + 1][N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ladder[a][b][b + 1] = true;
			ladder[a][b + 1][b] = true;
		}
		
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j < N; j++) {
				if(ladder[i][j][j + 1]) continue;
				
				candidates.add(new int[] {i, j});
			}
		}
		
		if(check()) {
			System.out.println(answer); return;
		}

		
		while(!isFinished && answer < 3) {
			answer++;
						
			select(new boolean[candidates.size()], new ArrayList<>(), 0, answer);
			
			if(isFinished) {
				System.out.println(answer); return;
			}
		}
		
		System.out.println(-1);
	}
	
	static void select(boolean[] vis, List<int[]> arr, int n, int k) {
		if(isFinished) return;
		
		if(n == k) {
			for(int i = 0; i < n; i++) {
				int a = arr.get(i)[0];
				int b = arr.get(i)[1];
				
				ladder[a][b][b + 1] = true;
				ladder[a][b + 1][b] = true;
			}
			
			
			if(check()) { 
				isFinished = true; return;
			}
			
			for(int i = 0; i < n; i++) {
				int a = arr.get(i)[0];
				int b = arr.get(i)[1];
				
				ladder[a][b][b + 1] = false;
				ladder[a][b + 1][b] = false;
			}
			
			return;
		}
		
		for(int i = 0; i < vis.length; i++) {
			if(vis[i]) continue;
			
			vis[i] = true;
			arr.add(candidates.get(i));
			select(vis, arr, n + 1, k);
			arr.remove(n);
			vis[i] = false;
		}			
	}
	
	static boolean check() {
		for(int i = 1; i <= N; i++) {
			int cur = i;
			
			for(int j = 1; j <= H; j++) {
				if(cur < N && ladder[j][cur][cur + 1]) cur = cur + 1;
				else if(cur > 1 && ladder[j][cur][cur - 1]) cur = cur - 1;
			}
			
			if(cur != i) return false;
		}
		
		return true;
	}
	
}