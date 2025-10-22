import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, a, b;
	static int[] answer;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		answer = new int[a + b - 1];
		
		if(N < a + b - 1) {
			System.out.print(-1); return;
		}
		
		int supply_num = N - (a + b) + 1;
		
		if(a < b) {	
			for(int i = answer.length - 1; i >= answer.length - b; i--) {
				answer[i] = answer.length - i;
			}
			
			for(int i = 0; i <= answer.length - b - 1; i++) {
				answer[i] = i + 1;
			}
		}
		else {
			for(int i = 0; i < a; i++) {
				answer[i] = i + 1;
			}
			
			for(int i = answer.length - 1; i >= a; i--) {
				answer[i] = answer.length - i;
			}
		}
	
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < answer.length; i++) {			
			sb.append(answer[i]).append(" ");
			
			if(i == 0) {
				for(int j = 0; j < supply_num; j++) 
					sb.append(1).append(" ");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
	

}

// 5 2 4
// 1 4 3 2 1