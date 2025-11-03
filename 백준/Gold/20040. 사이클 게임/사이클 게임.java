import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] p;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n];
		
		for(int i = 0; i < n; i++) {
			p[i] = i;
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(union(u, v)) {
				System.out.println(i);
				return;
			}

		}
		

		System.out.println(0);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		 
		
		if(px < py) p[py] = px;
		else if(px > py) p[px] = py;
		else return true;
		
		return false;
	}
	
	static int find(int x) {
		if(x == p[x]) return x;
		
		
		return p[x] = find(p[x]);
	}
	

}
