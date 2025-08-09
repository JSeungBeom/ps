import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K, N;
	static int[] lines;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(stz.nextToken());
		N = Integer.parseInt(stz.nextToken());
		
		lines = new int[K];
		
		for(int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		long st = 1;
		long en = Integer.MAX_VALUE;
		
		while(st < en) {
			long mid = (st + en + 1) / 2;
			
			if(binary_search(mid)) st = mid;
			else en = mid - 1;
		}
		
		System.out.println(st);
	}
	
	static boolean binary_search(long mid) {
		int cnt = 0;
		
		for(int i = 0; i < K; i++) {
			cnt += (lines[i] / mid);
		}
		
		return cnt >= N;
	}
	
}