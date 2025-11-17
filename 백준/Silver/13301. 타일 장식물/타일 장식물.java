import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dp1;
	static int[] dp2;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	if(N == 1) {
    		System.out.println(4); return;
    	}
    	
    	dp1 = new int[N + 1];
    	dp2 = new int[N + 1];
    	
    	dp1[1] = 1;
    	dp2[1] = 1;
    	
    	dp1[2] = 1;
    	dp2[2] = 2;
    	
    	for(int i = 3; i <= N; i++) {
    		dp1[i] = dp1[i - 1] + dp1[i - 2];
    		dp2[i] = dp1[i] + dp1[i - 1];
    	}
    	
    	System.out.println(dp1[N] * 2 + dp2[N] * 2);
    }

}
