import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, max;
	static int[] arr;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        dp = new int[N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < i; j++) {
        		if(arr[j] < arr[i]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	
        	max = Math.max(dp[i], max);
        }
        
        System.out.println(N - (max + 1));
        
        
    }
}

