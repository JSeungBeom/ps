import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String S;
	static int[] alpha = new int[26];
	static char[] answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = br.readLine();
        
        answer = new char[S.length()];
        
        for(int i = 0; i < S.length(); i++) {
        	alpha[S.charAt(i) - 'A']++;
        }
        
        
        if(S.length() % 2 == 0) {
        	int idx = 0;
        	
        	for(int i = 0; i < 26; i++) {
        		if(alpha[i] > 0 && alpha[i] % 2 == 1) {
        			System.out.println("I'm Sorry Hansoo"); return;
        		}
        		
        		for(int j = 0; j < alpha[i] / 2; j++) {
        			answer[idx] = (char)(i + 'A');
        			answer[answer.length - 1 - idx] = (char)(i + 'A');
        			idx++;
        		}
        	}
        }
        else {
        	int idx = 0;
            boolean isOdd = false;
        	int mid = S.length() / 2;
        	
	        for(int i = 0; i < 26; i++) {
	        	if(alpha[i] > 0 && alpha[i] % 2 == 1) {
	        		if(!isOdd) {
	        			isOdd = true;
	        			answer[mid] = (char)(i + 'A');
	        		}
	        		else {
	        			System.out.println("I'm Sorry Hansoo"); return;
	        		}
	        	}
	        	
	        	for(int j = 0; j < alpha[i] / 2; j++) {
        			answer[idx] = (char)(i + 'A');
        			answer[answer.length - 1 - idx] = (char)(i + 'A');
        			idx++;
	        	}
	        }
        }
        
        for(char c : answer) 
        	System.out.print(c);
    }
   
}

