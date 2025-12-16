import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int N;
	static List<Integer> psum = new ArrayList<>();
	static int[] dp;
	static int answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N + 1];
        
        psum.add(0);
        psum.add(1);
        
        Arrays.fill(dp, 500000);
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= N; i++) {
        	psum.add(psum.get(i - 1) + (psum.get(i - 1) - psum.get(i - 2) + i));
        	
        	if(psum.get(i) >= N) break;
        }
        
        for(int i = 1; i < psum.size(); i++) {
        	for(int j = psum.get(i); j <= N; j++) {
        		if(j - psum.get(i) >= 0)
        			dp[j] = Math.min(dp[j], dp[j - psum.get(i)] + 1);
        	}
        }
        
        System.out.println(dp[N]);
    }
}

