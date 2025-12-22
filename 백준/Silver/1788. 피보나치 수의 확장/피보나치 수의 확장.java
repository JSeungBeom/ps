import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N; 
	static final int MOD = 1_000_000_000;
	static final int OFFSET = 1_000_000;
	static int[] fibo = new int[2000005];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        fibo[OFFSET - 1] = 1;
        fibo[OFFSET] = 0;
        fibo[OFFSET + 1] = 1;

        if(N < 0) {
	        for(int i = 2; i <= -N; i++) {
	        	fibo[OFFSET - i] = (fibo[OFFSET - i + 2] - fibo[OFFSET - i + 1]) % MOD;
	        }
        }
        else {
	        for(int i = 2; i <= N; i++) {
	        	fibo[OFFSET + i] = (fibo[OFFSET + i - 1] + fibo[OFFSET + i - 2]) % MOD;
	        }
        }
        
        if(fibo[OFFSET + N] > 0) 
        	System.out.println(1);
        else if(fibo[OFFSET + N] == 0) 
        	System.out.println(0);
        else
        	System.out.println(-1);
        
        System.out.println(Math.abs(fibo[OFFSET + N]));
    }
    
}

