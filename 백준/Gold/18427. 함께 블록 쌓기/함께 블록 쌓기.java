import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, H;
	static List<List<Integer>> blocks = new ArrayList<>();
	static int[][] dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			blocks.add(new ArrayList<>());
		}
		
		dp = new int[N + 1][H + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				blocks.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= H; j++) {
				for(int block : blocks.get(i)) {
					if(j == block) dp[i][j]++;
					if(j > block)
						dp[i][j] += dp[i - 1][j - block];
				}
				dp[i][j] += dp[i - 1][j];
				dp[i][j] %= 10007;
			}
		}
		
		System.out.println(dp[N][H]);
	}

}
