import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static String S, T;
	static boolean isConvertible = false;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	S = br.readLine();
    	T = br.readLine();
    	
    	backTracking(S, T);
    	
    	if(isConvertible) System.out.println(1);
    	else System.out.println(0);
    }
    
    static void backTracking(String s, String t) {
    	if(t.length() < s.length()) return;

    	if(s.equals(t)) {
    		isConvertible = true;
    		return;
    	}
    	
    	StringBuilder sb = new StringBuilder(t);
    	
    	if(sb.charAt(sb.length() - 1) == 'A')
    		backTracking(s, sb.deleteCharAt(sb.length() - 1).toString());
    	else
    		backTracking(s, sb.deleteCharAt(sb.length() - 1).reverse().toString());
    	
    }
    


}

// ABBA
// ABB
// BA
// B
