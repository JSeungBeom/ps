import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[][] lecture;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		lecture = new int[3][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			lecture[0][i] = a + b;
			lecture[1][i] = b + c;
			lecture[2][i] = a + c;
		}
		
		for(int i = 0; i < 3; i++) {
			Arrays.sort(lecture[i]);
		}
		
		int[] sum = new int[3];
		
		for(int i = N - 1; i >= N - K; i--) {
			sum[0] += lecture[0][i];
			sum[1] += lecture[1][i];
			sum[2] += lecture[2][i];
		}
		
		System.out.println(Math.max(sum[2], Math.max(sum[0], sum[1])));
		
	}
	
}