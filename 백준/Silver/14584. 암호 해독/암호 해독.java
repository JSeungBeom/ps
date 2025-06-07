import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static String encoded;
	static int N;
	static String[] words;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		encoded = br.readLine();
		
		N = Integer.parseInt(br.readLine());
		
		words = new String[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			words[i] = st.nextToken();
		}
		
		for(int i = 0; i < 26; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < encoded.length(); j++) {
				if(Character.isUpperCase(encoded.charAt(j))) {
					if(encoded.charAt(j) - i < 'A')
						sb.append((char)(encoded.charAt(j) - i + 26));
					else
						sb.append((char)(encoded.charAt(j) - i));
				} else {
					if(encoded.charAt(j) - i < 'a')
						sb.append((char)(encoded.charAt(j) - i + 26));
					else
						sb.append((char)(encoded.charAt(j) - i));
				}
				
			} 
			
			for(int j = 0; j < N; j++) {
				if(sb.toString().contains(words[j])) {
					System.out.println(sb);
					return;
				}
			}	
		}
		
	}
	
}