import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int T, K;
	static String W;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
        	W = br.readLine();
        	K = Integer.parseInt(br.readLine());
        	
        	List<List<Integer>> alpha = new ArrayList<>();
        	
        	for(int j = 0; j < 26; j++) {
        		alpha.add(new ArrayList<>());
        	}
        	
        	for(int j = 0; j < W.length(); j++) {
        		alpha.get(W.charAt(j) - 'a').add(j);
        	}
        	
            int cnt1 = solve1(alpha);
            
            if(cnt1 == Integer.MAX_VALUE) {
            	System.out.println(-1);
            	continue;
            }
            
            System.out.print(cnt1 + " ");
            
            int cnt2 = solve2(alpha);
            
            System.out.println(cnt2);
        }
        

    }
    
   static int solve2(List<List<Integer>> alpha) {
	   int max = 0;
	   
	   for(int i = 0; i < 26; i++) {
			for(int j = 0; j + K - 1 < alpha.get(i).size(); j++) {
				if(W.charAt(alpha.get(i).get(j)) == W.charAt(alpha.get(i).get(j + K - 1))) {
					max = Math.max(max, alpha.get(i).get(j + K - 1) - alpha.get(i).get(j) + 1);
				}
			}
	   }
	   
	   return max;
	}

	static int solve1(List<List<Integer>> alpha) {
    	int min = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < 26; i++) {
    		if(alpha.get(i).size() >= K) {
    			for(int j = 0; j + K - 1 < alpha.get(i).size(); j++) {
    				min = Math.min(min, alpha.get(i).get(j + K - 1) - alpha.get(i).get(j) + 1);
    			}
    		}
    	}
    	
    	return min;
    }
}

// 1 2 3 4 5 6 7
// 3 2 1 5 6 4 7
