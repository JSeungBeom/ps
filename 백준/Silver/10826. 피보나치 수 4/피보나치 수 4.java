import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	static BigInteger[] fibo;
	static int N;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	if(N == 0) {
    		System.out.println(0);
    		return;
    	}
    	
    	fibo = new BigInteger[N + 1];
    	
    	fibo[0] = BigInteger.ZERO;
    	fibo[1] = BigInteger.ONE;
    	
    	for(int i = 2; i <= N; i++) {
    		fibo[i] = fibo[i - 1].add(fibo[i - 2]);
    	}
    	
    	System.out.println(fibo[N]);
    	
    }

}
