import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static String S;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
        	S = br.readLine();
        	
        	System.out.println(solve(S.length() / 2, S.length() / 2) ? "YES" : "NO");
        }
    }
    
    static boolean solve(int mid, int size) {
    	if(size == 0)
    		return true;
    	
    	for(int i = 1; i <= size; i++) {
    		if(S.charAt(mid + i) == S.charAt(mid - i)) 
    			return false;
    	}
    	
    	int half = size / 2;
    	int move = (size + 1) / 2;
    	
    	return solve(mid - move, half) && solve(mid + move, half);
    }
    

}