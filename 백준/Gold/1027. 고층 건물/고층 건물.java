import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int[] ans;
	static double[][] slope;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 2) {
			System.out.println(N - 1);
			return;
		}
		

		arr = new int[N + 1];
		ans = new int[N + 1];
		slope = new double[N + 1][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = i - 1; j >= 1; j--) {
				slope[i][j] = (double)(arr[i] - arr[j]) / (i - j);
			}
			
			for(int j = i + 1; j <= N; j++) {
				slope[i][j] = (double)(arr[j] - arr[i]) / (j - i);
			}
			
	
		}
		
		int mxVal = 0;
	
		for(int i = 1; i <= N; i++) {
			double left = Double.MAX_VALUE;
			double right = -Double.MAX_VALUE;
			
			for(int j = i - 1; j >= 1; j--) {
				if(slope[i][j] < left) {
					left = slope[i][j];
					ans[i]++;
				}
			}
			
			for(int j = i + 1; j <= N; j++) {
				if(slope[i][j] > right) {
					right = slope[i][j];
					ans[i]++;
				}
			}
			
			mxVal = Math.max(mxVal, ans[i]);
		}
		
		System.out.println(mxVal);
		
	}
	
}
