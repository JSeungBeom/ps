import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static int N;
	static String[] words;
	static int[] alpha = new int[26];
	static Map<Integer, Integer> map = new HashMap<>();
	static List<int[]> scores = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        
        words = new String[N];
        
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < words[i].length(); j++) {
        		int cur = words[i].charAt(j) - 'A';
        		int score = (int) Math.pow(10, words[i].length() - j - 1);
        		
        		map.put(cur, map.getOrDefault(cur, 0) + score);
        	}
        }
        
        for(int key : map.keySet()) {
        	scores.add(new int[] {key, map.get(key)});
        }
        
        Collections.sort(scores, (o1, o2) -> (o2[1] - o1[1]));
       
        int start = 9;
        
        for(int i = 0; i < scores.size(); i++) {
        	alpha[scores.get(i)[0]] = start--;
        }
        	
        int answer = 0;
        
        for(int i = 0; i < N; i++) {
        	int cur = 0;
        	
        	for(int j = 0; j < words[i].length(); j++) {
        		int idx = words[i].charAt(j) - 'A';
        		cur = cur * 10 + alpha[idx];
        	}
        	        	
        	answer += cur;
        }
        
        System.out.println(answer);
    }
    
}
