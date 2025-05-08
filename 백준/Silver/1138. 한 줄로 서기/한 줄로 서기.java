import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] order;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		order = new int[N];
		
		Arrays.fill(order, 15);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int height = 1;

		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {

				if(cnt < arr[i] && order[j] == 15) {
					cnt++;
				}
				else if(order[j] != 15) {
					continue;
				}
				else if(cnt == arr[i] && order[j] == 15) {
					order[j] = height++; 
					break;
				}
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(order[i] + " ");
		}
	}
}