import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static int T;
	static String S;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	T = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < T; i++) {
    		S = br.readLine();
    		
    		System.out.println(checkPalindrome(0, S.length() - 1, 0, S));
    	}
    }
    
    static int checkPalindrome(int l, int r, int delete, String s) {
    	while(l < r) {
    		if(s.charAt(l) != s.charAt(r)) {
    			if(delete == 0) {
    				if(checkPalindrome(l + 1, r, 1, s) == 0 || checkPalindrome(l, r - 1, 1, s) == 0) return 1;
    				
    				return 2;
    			}
    			return 2;
    		}
    		else {
    			l++;
    			r--;
    		}
    	}
    	
    	return 0;
    }

}

// summuus
// suummus

