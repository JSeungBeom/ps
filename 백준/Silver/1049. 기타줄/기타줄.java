import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] six;
	static int[] one;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        six = new int[M];
        one = new int[M];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	six[i] = Integer.parseInt(st.nextToken());
        	one[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(six);
        Arrays.sort(one);
        
        if(one[0] * 6 < six[0]) {
        	System.out.println(one[0] * N);
        }
        else {
        	int price = six[0] * (N / 6);
        	int res = N % 6;
        	
        	price += one[0] * res < six[0] ? one[0] * res : six[0];
        	
        	System.out.println(price);
        }
    }
    

}
