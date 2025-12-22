import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int max;
	static int answer;
	static List<Integer> negative = new ArrayList<>();
	static List<Integer> positive = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
    	st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	int num = Integer.parseInt(st.nextToken());

        	if(num > 0)
        		positive.add(num);
        	else
        		negative.add(-num);
        }
        
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());
        
        for(int i = 0; i < positive.size(); i += M) {
        	answer += (positive.get(i) * 2);
        	
        	max = Math.max(positive.get(i), max);
        }
        
        for(int i = 0; i < negative.size(); i += M) {
        	answer += (negative.get(i) * 2);
        	
        	max = Math.max(negative.get(i), max);
        }
        
        answer -= max;
        
        System.out.println(answer);
        
    }
}

