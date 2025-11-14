import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int answer;
	static int[] sensors;
	static int[] diffs;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        sensors = new int[N];
        diffs = new int[N - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	sensors[i] = Integer.parseInt(st.nextToken()); 
        }
        
        if(K >= N) {
        	System.out.println(0);
        	return;
        }
        
        Arrays.sort(sensors);
        
        for(int i = 0; i < N - 1; i++) {
        	diffs[i] = sensors[i + 1] - sensors[i];
        }
        
        Arrays.sort(diffs);
        
        for(int i = 0; i < N - K; i++) {
        	answer += diffs[i];
        }
        
        System.out.println(answer);
    }
    
}
