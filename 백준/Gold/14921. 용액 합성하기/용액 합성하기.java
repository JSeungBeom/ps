import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static int answer;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 0; i < N; i++) {
    		int idx1 = upperBound(0, N - 1, -arr[i]);
    		int idx2 = lowerBound(0, N - 1, -arr[i]);
    		
    		if(idx1 != i) {
    			if(min > Math.abs(arr[i] + arr[idx1])) {
    				min = Math.abs(arr[i] + arr[idx1]);
    				answer = arr[i] + arr[idx1];
    			}
    			
    			if(idx1 + 1 < N && idx1 - 1 >= 0) {
        			if(min > Math.abs(arr[i] + arr[idx1 + 1])) {
        				min = Math.abs(arr[i] + arr[idx1 + 1]);
        				answer = arr[i] + arr[idx1 + 1];
        			}
    			}
    		}
    		
    		if(idx2 != i) {
    			if(min > Math.abs(arr[i] + arr[idx2])) {
    				min = Math.abs(arr[i] + arr[idx2]);
    				answer = arr[i] + arr[idx2];
    			}
    			
    			if(idx2 - 1 != i && idx2 - 1 >= 0) {
        			if(min > Math.abs(arr[i] + arr[idx2 - 1])) {
        				min = Math.abs(arr[i] + arr[idx2 - 1]);
        				answer = arr[i] + arr[idx2 - 1];
        			}
    			}
    		}
    	}
    	
    	System.out.println(answer);
	}
	
	static int upperBound(int st, int en, int target) {
		while(st < en) {
			int mid = (st + en) / 2;
		
			if(arr[mid] <= target) st = mid + 1;
			else en = mid;
		}
		
		return st;
	}
	
	static int lowerBound(int st, int en, int target) {
		while(st < en) {
			int mid = (st + en) / 2;
			
			if(arr[mid] < target) st = mid + 1;
			else en = mid;
		}
		
		return st;
	}
}