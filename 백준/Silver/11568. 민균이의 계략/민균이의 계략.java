import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
    static int[] dp;
	static int answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        dp = new int[N];
        
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < i; j++) {
        		if(arr[i] > arr[j]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	
        	answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
}
