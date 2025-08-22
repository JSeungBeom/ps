import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			System.out.println(binarySearch(target));
		}
		
	}
	
	static int binarySearch(int target) {
		int st = 0;
		int en = N - 1;
		
		while(st <= en) {
			int mid = (st + en) / 2;
			 
			if(arr[mid] > target) en = mid - 1;
			else if(arr[mid] < target) st = mid + 1;
			else return 1;
		}
		
		return 0;
	}

	
}