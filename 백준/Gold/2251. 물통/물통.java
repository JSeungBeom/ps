import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int A, B, C;
	static Set<Integer> set = new TreeSet<>();
	static boolean[][][] vis;
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		vis = new boolean[A + 1][B + 1][C + 1];
		
		dfs(0, 0, C);
	
		for(int e : set) {
			System.out.print(e + " ");
		}
		
	}
	
	static void dfs(int containerA, int containerB, int containerC) {
		if(vis[containerA][containerB][containerC]) return;
		vis[containerA][containerB][containerC] = true;
		
		if(containerA == 0) {
			set.add(containerC);
		}
		
		if(containerB < B) {
			int pour = B - containerB;
			if(containerA > pour) {
				if(!vis[containerA - pour][containerB + pour][containerC]) {
					dfs(containerA - pour, containerB + pour, containerC);
				}
			}
			else if(containerA > 0) {
				if(!vis[0][containerB + containerA][containerC]) {
					dfs(0, containerB + containerA, containerC);
				}
			}
				
			if(containerC > pour) {
				if(!vis[containerA][containerB + pour][containerC - pour]) {
					dfs(containerA, containerB + pour, containerC - pour);
				}
			}
			else if(containerC > 0) {
				if(!vis[containerA][containerB + containerC][0]) {
					dfs(containerA, containerB + containerC, 0);
				}
			}
		}
		
		if(containerA < A) {
			int pour = A - containerA;
			
			if(containerB > pour) {
				if(!vis[containerA + pour][containerB - pour][containerC]) {
					dfs(containerA + pour, containerB - pour, containerC);
				}
			}
			else if(containerB > 0) {
				if(!vis[containerA + containerB][0][containerC]) {
					dfs(containerA + containerB, 0, containerC);
				}
			}
		
			if(containerC > pour) {
				if(!vis[containerA + pour][containerB][containerC - pour]) {
					dfs(containerA + pour, containerB, containerC - pour);
				}
			}
			else if(containerC > 0) {
				if(!vis[containerA + containerC][containerB][0]) {
					dfs(containerA + containerC, containerB, 0);
				}
			}
		}
		
		if(containerC < C) {
			int pour = C - containerC;
			
			if(containerA > pour) {
				if(!vis[containerA - pour][containerB][containerC + pour]) {
					dfs(containerA - pour, containerB, containerC + pour);
				}
			}
			else if(containerA > 0) {
				if(!vis[0][containerB][containerC + containerA]) {
					dfs(0, containerB, containerC + containerA);
				}
			}
			if(containerB > pour) {
				if(!vis[containerA][containerB - pour][containerC + pour]) {
					dfs(containerA, containerB - pour, containerC + pour);
				}
			}
			else if(containerB > 0) {
				if(!vis[containerA][0][containerC + containerB]) {
					dfs(containerA, 0, containerC + containerB);
				}
			}
		}
	}
	

}

// 5 2 4
// 1 4 3 2 1