import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static String s1, s2;
	static int[][] dp;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s1 = br.readLine();
		s2 = br.readLine();
		dp = new int[s1.length()][s2.length()];
		
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					if(i - 1 >= 0 && j - 1 >= 0)
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
					else
						dp[i][j] += 1;
				}

				ans = Math.max(dp[i][j], ans);
			}
		}
		

		
		System.out.println(ans);
  	}
}