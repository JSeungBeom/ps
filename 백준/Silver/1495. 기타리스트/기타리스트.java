import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S, M;
	static int[] volume;
	static boolean[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		volume = new int[N + 1];
		dp = new boolean[N + 1][M + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][S] = true;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				if(dp[i - 1][j]) {
					if(j + volume[i] <= M)
					dp[i][j + volume[i]] = true;
					if(j - volume[i] >= 0)
					dp[i][j - volume[i]] = true;
				}
			}
		}


		for(int j = M; j >= 0; j--) {
			if(dp[N][j]) {
				System.out.println(j); return;
			}
		}
		
		System.out.println(-1);
  	}
}