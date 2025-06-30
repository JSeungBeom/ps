import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static String S;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		int idx = 0; 
		int cnt = 0;
		
		while(S.charAt(idx) == 'B' && idx < N - 1) idx++;
				
		while(idx < N) {
			if(S.charAt(idx) == 'B') cnt++;
			idx++;
		}
		
		ans = Math.min(ans, cnt);
		
		idx = 0;
		cnt = 0;
		
		while(S.charAt(idx) == 'R' && idx < N - 1) idx++;
		
		while(idx < N) {
			if(S.charAt(idx) == 'R') cnt++;
			idx++;
		}
		
		ans = Math.min(ans, cnt);

		idx = N - 1; 
		cnt = 0;
		
		while(S.charAt(idx) == 'B' && idx > 0) idx--;
				
		while(idx >= 0) {
			if(S.charAt(idx) == 'B') cnt++;
			idx--;
		}
		
		ans = Math.min(ans, cnt);
		
		idx = N - 1;
		cnt = 0;
		
		while(S.charAt(idx) == 'R' && idx > 0) idx--;
		
		while(idx >= 0) {
			if(S.charAt(idx) == 'R') cnt++;
			idx--;
		}
		
		ans = Math.min(ans, cnt);
		
		System.out.println(ans);
		
	}
	
}