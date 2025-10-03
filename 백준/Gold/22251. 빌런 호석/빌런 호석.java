import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, P, X;
	static int[] num = new int[10];
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		num[0] = makeDisplay(new int[] {3});
		num[1] = makeDisplay(new int[] {1, 3, 4, 6, 7});
		num[2] = makeDisplay(new int[] {4, 5});
		num[3] = makeDisplay(new int[] {4, 7});
		num[4] = makeDisplay(new int[] {1, 6, 7});
		num[5] = makeDisplay(new int[] {2, 7});
		num[6] = makeDisplay(new int[] {2});
		num[7] = makeDisplay(new int[] {3, 4, 6, 7});
		num[8] = makeDisplay(new int[] {});
		num[9] = makeDisplay(new int[] {7});
		
		String cur = String.valueOf(X);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < K - cur.length(); i++) {
			sb.append('0');
		}
		
		sb.append(cur);
		
		cur = sb.toString();
		
		for(int rep = 1; rep < Math.pow(10, cur.length()); rep++) {
			if(rep == Integer.parseInt(cur)) continue;
			if(rep > N) break;
			
			String now = String.valueOf(rep);
			
			sb = new StringBuilder();
			
			for(int i = 0; i < K - now.length(); i++) {
				sb.append('0');
			}
			
			now = sb.append(now).toString();
			
			int sum = 0;
			
			for(int i = 0; i < K; i++) {
				int nowNum = now.charAt(i) - '0';
				int curNum = cur.charAt(i) - '0'; 
				
				sum += (Integer.bitCount(num[curNum] | num[nowNum]) - Integer.bitCount(num[curNum] & num[nowNum]));
				
			}
			
			if(sum <= P) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int makeDisplay(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += (1 << arr[i]);
		}
		
		return sum;
	}

}

// 0058
// 0000
// 0001
