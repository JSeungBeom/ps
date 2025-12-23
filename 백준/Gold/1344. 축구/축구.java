import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int A, B;
	static double[] percentA, percentB;
	static double notPrimeA, notPrimeB;
	static double answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        
        percentA = new double[20];
        percentB = new double[20];
        
        for (int i = 0; i <= 18; i++) {
            double pA = A / 100.0;
            double pB = B / 100.0;

            percentA[i] = comb(18, i)
                    * Math.pow(pA, i)
                    * Math.pow(1 - pA, 18 - i);

            percentB[i] = comb(18, i)
                    * Math.pow(pB, i)
                    * Math.pow(1 - pB, 18 - i);
        }

        for(int i = 0; i <= 18; i++) {
        	if(!isPrime(i)) {
        		notPrimeA += percentA[i];
        		notPrimeB += percentB[i];
        	}
        }
        
        System.out.println(1 - (notPrimeA * notPrimeB));
    }
    
    static boolean isPrime(int N) {
    	if(N <= 1) return false;
    	if(N == 2) return true;
    	
    	for(int i = 2; i * i <= N; i++) {
    		if(N % i == 0) return false;
    	}

    	return true;
    }
    
    static double comb(int N, int K) {
    	long val1 = 1;
    	long val2 = 1;
    	
    	for(int i = N - K + 1; i <= N; i++) {
    		val1 *= i;
    	}
    	
    	for(int i = 1; i <= K; i++) {
    		val2 *= i;
    	}
    	
    	return (double) val1 / val2;
    }
    
}

