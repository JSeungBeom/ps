import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String s;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		s = br.readLine();
		int aCnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a') aCnt++; 
		}
		
		for(int i = 0; i < s.length(); i++) {
			int bCnt = 0;
			for(int j = i; j < i + aCnt; j++) {
				if(s.charAt(j % s.length()) == 'b') bCnt++;  
			}
			
			min = Math.min(min, bCnt);
		}
		
		System.out.print(min);
	}

}


// aba b aba b aba b aba
// aba b aba b aba b a