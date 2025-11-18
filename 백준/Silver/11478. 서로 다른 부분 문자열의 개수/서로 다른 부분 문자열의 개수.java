import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static Set<String> set = new HashSet<>();
	static String S;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	S = br.readLine();
    	
    	for(int i = 0; i < S.length(); i++) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(S.charAt(i));
    		
    		set.add(sb.toString());
    		
    		for(int j = i + 1; j < S.length(); j++) {
    			sb.append(S.charAt(j));
    			
    			set.add(sb.toString());
    		}
    	}
    	
    	System.out.println(set.size());
    }
    


}
