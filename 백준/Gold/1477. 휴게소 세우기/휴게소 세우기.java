import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, L;
	static List<Integer> rest = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        rest.add(0);
        
        for(int i = 0; i < N; i++) {
        	rest.add(Integer.parseInt(st.nextToken()));
        }

        rest.add(L);
        
        Collections.sort(rest);
        
    	int start = 1;
    	int end = L - 1;
    	
    	while(start < end) {
    		int mid = (start + end) / 2;
    		
    		if(solve(mid)) end = mid;
    		else start = mid + 1;
    	}
        	
        System.out.println(start);
    }
    
    static boolean solve(int mid) {
    	int cnt = 0;
    	
    	for(int i = 0; i < N + 1; i++) {
    		int dist = (rest.get(i + 1) - rest.get(i));
    		cnt += (dist - 1) / mid;
    	}
    	
    	return cnt <= M;
    }
    
}

// 0 13 -> 3 3 3 3