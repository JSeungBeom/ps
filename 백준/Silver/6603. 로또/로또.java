import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			K = Integer.parseInt(st.nextToken());
			
			if(K == 0) return;
			
			int[] combinations = new int[K];
			int[] arr = new int[6];
			boolean[] vis = new boolean[K];
			
			for(int i = 0; i < K; i++) {
				combinations[i] = Integer.parseInt(st.nextToken());
			}
			
			backTracking(0, 0, combinations, arr, vis);
			System.out.println();
		}
	}
	
	static void backTracking(int N, int last, int[] combinations, int[] arr, boolean[] vis) {
		if(N == 6) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}
			
			System.out.println(sb);
			
			return;
		}
		
		for(int i = last; i < K; i++) {
			if(vis[i]) continue;
			
			arr[N] = combinations[i];
			vis[i] = true;
			backTracking(N + 1, i, combinations, arr, vis);
			vis[i] = false;
		}
		
		
	}
	
}