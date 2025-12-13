import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int X, Y, W, S;
	static long answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        
        long target1 = X < Y ? X : Y;
        
    	answer += W * 2 < S ? W * 2 * target1 : S * target1;
    	
		
    	long target2 = Math.abs(X - Y) / 2;
    	
    	answer += W < S ? W * 2 * target2 : S * 2 * target2; 
    	
    	
		long target3 = Math.abs(X - Y) % 2;
		
		answer += W * target3;
		
		
		System.out.println(answer);
    }
    
    // 41010000000
    // 2355294336

}