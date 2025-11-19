import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static String S;
	static boolean isPattern;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	T = Integer.parseInt(br.readLine());
    	
    	// (100+1+ | 01)+
    	// 1001 01 10001 0101 100011
    	
    	for(int i = 0; i < T; i++) {
    		S = br.readLine();
    		
    		isPattern = false;
    		backTracking(S);
    		
    		System.out.println(isPattern ? "YES" : "NO");
    	}
    	
    	
    }
    
    static void backTracking(String s) {
    	if(s.length() == 1) return;
    	
    	if(s == "" || s.length() == 0) {
    		isPattern = true;
    		
    		return;
    	}
    	
    	int n = s.length();
    	
    	
    	if(s.charAt(n - 1) == '0') return;
    	
    	if(s.substring(n - 2, n).equals("01")) {
    		backTracking(s.substring(0, n - 2));
    	}
    	
    	int beginIdx1 = -1;
    	int beginIdx2 = -1;
    	
    	for(int i = n - 1; i >= 0; i--) {
    		if(s.charAt(i) == '0') { 
    			beginIdx1 = i; break;
    		}
    	}
    	
    	if(beginIdx1 == -1) return;
    	
    	int zeroCnt = 0;
    	
    	for(int i = beginIdx1; i >= 0; i--) {    		
    		if(s.charAt(i) == '1') {
    			beginIdx2 = i; break;
    		}
    		
    		zeroCnt++;
    	}
    	
    	if(beginIdx2 == -1 || zeroCnt < 2) return;
    	
    	backTracking(s.substring(0, beginIdx2));
    }

}

