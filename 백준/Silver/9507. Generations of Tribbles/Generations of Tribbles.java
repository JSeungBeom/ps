import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int t, n;
	static long[] fibo;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
         
        fibo = new long[80];
        
        fibo[0] = 1;
        fibo[1] = 1;
        fibo[2] = 2;
        fibo[3] = 4;
        
        for(int i = 4; i <= 67; i++) {
        	fibo[i] = fibo[i - 1] + fibo[i - 2] + fibo[i - 3] + fibo[i - 4];
        }
        
        for(int i = 0; i < t; i++) {
        	n = Integer.parseInt(br.readLine());
        	
        	System.out.println(fibo[n]);
        }
    }
   
}

