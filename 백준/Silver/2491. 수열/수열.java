import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] down_dp;
	static int[] up_dp;
	static int N;
	static int answer;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N + 1];
    	down_dp = new int[N + 1];
    	up_dp = new int[N + 1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 1; i <= N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		if(arr[i] >= arr[i - 1]) {
    			up_dp[i] = up_dp[i - 1] + 1;
    		}
    		else 
    			up_dp[i] = 1;
    		
    		answer = Math.max(answer, up_dp[i]);
    	}
    	
    	arr[0] = 10;
    	
    	for(int i = 1; i <= N; i++) {
    		if(arr[i] <= arr[i - 1]) {
    			down_dp[i] = down_dp[i - 1] + 1;
    		}
    		else
    			down_dp[i] = 1;

    		answer = Math.max(answer, down_dp[i]);
    	}
    	
    	System.out.println(answer);
    	
    }

}
