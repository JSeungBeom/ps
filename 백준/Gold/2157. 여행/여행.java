import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static List<int[]> roads = new ArrayList<>();
	static int[][] dp;
	static int answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
    
        dp = new int[N + 1][M + 1];
        
        for(int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	roads.add(new int[] {a, b, c});
        }
        
        Collections.sort(roads, (r1, r2) -> (r1[1] == r2[1] ? r1[0] - r2[0] : r1[1] - r2[1]));
        
        for(int i = 1; i <= N; i++) 
        	Arrays.fill(dp[i], Integer.MIN_VALUE);
        
        dp[1][1] = 0;
        
        for(int i = 0; i < K; i++) {
        	int[] cur = roads.get(i);
        	
        	int a = cur[0];
        	int b = cur[1];
        	int c = cur[2];
        	
        	if(a > b) continue;
        	
        	for(int j = 1; j <= M; j++) {
        		dp[b][j] = Math.max(dp[b][j], dp[a][j - 1] + c);
        	}
        }

        for(int i = 0; i <= M; i++) {
        	answer = Math.max(answer, dp[N][i]);
        }
        
        System.out.println(answer);
    }
    

    
}