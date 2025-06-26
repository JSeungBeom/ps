import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, D;
	static List<int[]> list = new ArrayList<>();
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][D + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			list.add(new int[] { start, end, len });
		}
	
		Collections.sort(list, (n1, n2) -> (n1[0] - n2[0]));
		
		for(int i = 0; i <= D; i++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			int start = list.get(i - 1)[0];
			int end = list.get(i - 1)[1];
			int len = list.get(i - 1)[2];
			
			for(int j = 0; j <= D; j++) {
				if(j >= end) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][start] + len + (j - end));
				}
				else {
					dp[i][j] = Math.min(dp[i - 1][j], j);
				}
			}
		}
		
		System.out.println(dp[N][D]);
	}
	
}