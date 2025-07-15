import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int x1, y1, x2, y2;
	static boolean[][] vis = new boolean[502][502];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j < x2; j++) {
				for(int k = y1; k < y2; k++) {
					vis[j][k] = true;
				}
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i <= 500; i++) {
			for(int j = 0; j <= 500; j++) {
				if(vis[i][j])
					answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
}