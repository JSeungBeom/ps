import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String S;
	static boolean isStarted;
	static StringBuilder answer = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	S = br.readLine();
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < S.length(); i++) {
    		if(S.charAt(i) == '<') isStarted = true;
    		
    		if(isStarted) {
    			answer.append(sb.reverse().toString());
    			answer.append(S.charAt(i));
    			sb = new StringBuilder();
    		}
    		else if(S.charAt(i) == ' ') {
    			answer.append(sb.reverse().toString() + ' ');
    			sb = new StringBuilder();
    		}
    		else {
    			sb.append(S.charAt(i));
    		}
    		
    		if(S.charAt(i) == '>') isStarted = false;
    	}
    	
    	answer.append(sb.reverse().toString());
    	
    	System.out.println(answer.toString());
    }

}

