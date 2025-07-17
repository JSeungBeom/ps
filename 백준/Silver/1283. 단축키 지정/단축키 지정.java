import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static int N;
	static String input, answer;
	static HashSet<Character> set = new HashSet<>();
	 
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			
			String[] divided = input.split(" ");
			char c = ' ';
			
			int M = divided.length;

			boolean isFin = false;
			
			
			for(int j = 0; j < M; j++) {
				if(!set.contains(Character.toLowerCase(divided[j].charAt(0))) 
						&& !set.contains(Character.toUpperCase(divided[j].charAt(0)))) {
					set.add(divided[j].charAt(0));
					c = divided[j].charAt(0);
					isFin = true;
					break;
				}
			}
			
			if(!isFin) {
				for(int j = 0; j < M; j++) {
					for(int k = 0; k < divided[j].length(); k++) {
						if(!set.contains(Character.toLowerCase(divided[j].charAt(k))) 
								&& !set.contains(Character.toUpperCase(divided[j].charAt(k)))) {
							set.add(divided[j].charAt(k));
							c = divided[j].charAt(k);
							isFin = true;
							break;
						}	
					}
					if(isFin) break;
				}
			}
			
			isFin = false;
			
			if(c != ' ') {
				String replaced = "[" + c + "]";
				
				for(int j = 0; j < M; j++) {
					if(divided[j].charAt(0) == c) {
						divided[j] = divided[j].replaceFirst(Character.toString(c), replaced);
						isFin = true;
						break;
					}
				}
				
				if(isFin) {
					for(int j = 0; j < M; j++) {
						System.out.print(divided[j] + " ");
					}
					System.out.println();
					continue;
				}
				
				answer = input.replaceFirst(Character.toString(c), replaced);
				
				
			} else {
				answer = input;
			}
			
			System.out.println(answer);
		}
	}
	
}