import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static String input, target;
	static int[] swit, light;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        input = br.readLine();
        target = br.readLine();
        
        swit = toIntArray(input);
        light = toIntArray(target);
        
        if(isSame(swit, light)) {
        	System.out.println(0); return;
        }
        
        int[] tmp1 = Arrays.copyOf(swit, N);
        int[] tmp2 = Arrays.copyOf(swit, N);
        
        tmp1[0] = 1 - tmp1[0];
        tmp1[1] = 1 - tmp1[1];
        
        
        int cnt1 = solve(tmp1, light);
        int cnt2 = solve(tmp2, light);

        
        if(cnt1 == Integer.MAX_VALUE - 1 && cnt2 == Integer.MAX_VALUE - 1) System.out.println(-1);
        else {
        	System.out.println(Math.min(cnt1 + 1, cnt2));
        }
        
    }
    
    static int solve(int[] a, int[] b) {
    	int cnt = 0;
    	
    	for(int i = 1; i < N; i++) {
    		if(a[i - 1] != b[i - 1]) {
    			a[i - 1] = 1 - a[i - 1];
    			a[i] = 1 - a[i];
    			
    			if(i != N - 1) {
    				a[i + 1] = 1 - a[i + 1];
    			}
    			
    			cnt++;
    		}
    	}
    	
    	if(isSame(a, b)) return cnt;
    	
    	return Integer.MAX_VALUE - 1;
    }
    
    static int[] toIntArray(String s) {
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = s.charAt(i) - '0';
    	}
    	
    	return arr;
    }
    
    static boolean isSame(int[] a, int [] b) {
    	for(int i = 0; i < N; i++) {
    		if(a[i] != b[i]) return false;
    	}
    	
    	return true;
    }

}

// 1 2 3 4 5 6 7
// 3 2 1 5 6 4 7
