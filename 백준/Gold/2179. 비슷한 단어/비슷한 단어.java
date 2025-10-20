import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int N, max;	
	static Map<String, Integer> map = new HashMap<>();
	static List<int[]> list = new ArrayList<>();
	static String[] words;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		words = new String[N];
		
		for(int i = 0; i < N; i++) {			
			words[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			String tmp = "";
			
			for(int j = 0; j < words[i].length(); j++) {
				tmp += words[i].charAt(j);
				
				if(map.containsKey(tmp)) 
					max = Math.max(max, tmp.length());
				else
					map.put(tmp, i);
			}
		}
		
		for(int i = 0; i < N; i++) {
			String tmp = "";
			
			for(int j = 0; j < words[i].length(); j++) {
				tmp += words[i].charAt(j);
				
				if(map.containsKey(tmp)) {
					if(tmp.length() == max && i != map.get(tmp)) {
						int idx1 = i;
						int idx2 = map.get(tmp);
						
						if(idx1 > idx2) {
							list.add(new int[] {idx2, idx1});
						} else {
							list.add(new int[] {idx1, idx2});
						}
					}
				}
			}
		}
		
		Collections.sort(list, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

		for(int i = 0; i < list.size(); i++) {
			String word1 = words[list.get(i)[0]];
			String word2 = words[list.get(i)[1]];
			
			if(!word1.equals(word2)) {
				System.out.print(word1 + "\n" + word2);
				return;
			}
		}
	}

}