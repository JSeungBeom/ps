import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] jewel;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		jewel = new int[M];
		
		for(int i = 0; i < M; i++) {
			jewel[i] = Integer.parseInt(br.readLine());
		}
		
		int start = 1;
		int end = 1000000000;
		
		while(start < end) {
			int mid = (start + end - 1) / 2;
			
			if(solve(mid)) end = mid;
			else start = mid + 1;
		}

		System.out.println(start);
	}
	
	static boolean solve(int mid) {
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			cnt += (jewel[i] / mid);
			if(jewel[i] % mid != 0)
				cnt++;
		}
		
		return cnt <= N;
	}
	
}