import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main { 
	
	static String S, T;
	static boolean canComplete = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		S = br.readLine();
		T = br.readLine();
		
		DFS(S, T);
		
		System.out.println(canComplete == true ? 1 : 0);
	}
	
	static void DFS(String s, String t) {
		if(canComplete) return;
		
		if(s.length() == t.length()) {
			if(s.equals(t)) canComplete = true;
			
			return;
		}
		
		StringBuilder sb = new StringBuilder(t);
		
		if(sb.charAt(0) == 'B') {
			DFS(s, sb.reverse().deleteCharAt(sb.length() - 1).toString());
		}
		
		sb = new StringBuilder(t);
		
		if(sb.charAt(sb.length() - 1) == 'A') {
			DFS(s, sb.deleteCharAt(sb.length() - 1).toString());
		}
	}

}

// BABA

// BAAA
// BAAAB

// ABABAB
// BABABAB

// A

// AAAAA
// BAABAAAAAB