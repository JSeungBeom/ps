import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, L, K;
	static List<int[]> stars = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			stars.add(new int[] {x, y});
		}
		
		System.out.println(countingStars());
	}
	
	static int countingStars() {
		int max = 0;
		
		for(int i = 0; i < stars.size(); i++) {
			for(int j = 0; j < stars.size(); j++) {
				int x = stars.get(i)[0];
				int y = stars.get(j)[1];
				
				int cnt = 0;
				
				for(int[] dot : stars) {
					if(x > dot[0] || x + L < dot[0] || y > dot[1] || y + L < dot[1]) continue;
					
					cnt++;
				}
				
				max = Math.max(max, cnt);
			}
		}
		
		return K - max;
	}

}