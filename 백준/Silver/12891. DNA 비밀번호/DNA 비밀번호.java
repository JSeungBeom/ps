import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int sLen, pLen, answer;
	static String S;
	static int[] alpha = new int[26];
	static int[] newAlpha = new int[26];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	sLen = Integer.parseInt(st.nextToken());
    	pLen = Integer.parseInt(st.nextToken());
    	
    	S = br.readLine();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	alpha['A' - 'A'] = Integer.parseInt(st.nextToken());
    	alpha['C' - 'A'] = Integer.parseInt(st.nextToken());
    	alpha['G' - 'A'] = Integer.parseInt(st.nextToken());
    	alpha['T' - 'A'] = Integer.parseInt(st.nextToken());
    	
    	int end = 0;
    	
    	for(int start = 0; start < sLen - pLen + 1; start++) {
    		
    		while(end < sLen && end - start < pLen) {
    			newAlpha[S.charAt(end) - 'A']++;
    			end++;
    		}
    		
    		if(
				alpha['A' - 'A'] <= newAlpha['A' - 'A']
				&& alpha['C' - 'A'] <= newAlpha['C' - 'A']
				&& alpha['G' - 'A'] <= newAlpha['G' - 'A']
				&& alpha['T' - 'A'] <= newAlpha['T' - 'A']
			)
    		answer++;
    		
    		newAlpha[S.charAt(start) - 'A']--;
    	}
    	
    	System.out.println(answer);
    }

}

