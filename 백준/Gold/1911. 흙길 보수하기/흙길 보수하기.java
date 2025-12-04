import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L;
	static int[][] pawn;
	static int answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        pawn = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < 2; j++) {
        		pawn[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        Arrays.sort(pawn, (p1, p2) -> (p1[0] - p2[0]));
        
        int cur = 0;
        
        for(int i = 0; i < N; i++) {
        	int start = pawn[i][0];
        	int end = pawn[i][1];
        	
        	if(cur >= start) {
        		if(end - cur <= 0) continue;
        		
        		int cnt = (end - cur) % L == 0 ? (end - cur) / L : (end - cur) / L + 1;
        		cur = cur + (cnt * L);
        		answer += cnt;
        	}
        	else {
        		int cnt = (end - start) % L == 0 ? (end - start) / L : (end - start) / L + 1;
        		cur = start + (cnt * L);
        		answer += cnt;
        	}
        }
        
        System.out.println(answer);
    }
    

    

}
