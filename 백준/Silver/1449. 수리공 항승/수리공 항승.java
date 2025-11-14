import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L;
	static int[] pos;
	static int[] diffs;
		
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        pos = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	pos[i] = Integer.parseInt(st.nextToken());
        }
        
        if(N == 1) {
        	System.out.println(1); return;
        }
        
        diffs = new int[N - 1];
        
        Arrays.sort(pos);
        
        for(int i = 0; i < N - 1; i++) {
        	diffs[i] = pos[i + 1] - pos[i];
        }
        
        int answer = 1;
        
        int sum = 0;
        
        for(int i = 0; i < N - 1; i++) {
        	if(sum + diffs[i] > L - 1) {
        		answer++;
        		sum = 0;
        	}
        	else
        		sum += diffs[i];
        }
        
        System.out.println(answer);
        
    }
    
}
