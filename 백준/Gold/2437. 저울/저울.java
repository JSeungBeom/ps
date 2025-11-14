import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] choo;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        choo = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	choo[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(choo);
        
        int psum = 0;
        
        for(int i = 0; i < N; i++) {
        	if(choo[i] <= psum + 1) 
        		psum += choo[i];
        	else 
        		break;
        }
        
        System.out.println(psum + 1);
        
    }
    
}
