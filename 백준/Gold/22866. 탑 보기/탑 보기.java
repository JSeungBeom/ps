import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] buildings;
	static int[] arr;
	static int[] num;
	static int[] dist;
	static Deque<int[]> stack = new ArrayDeque<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        N = Integer.parseInt(br.readLine());
        
        buildings = new int[N + 1];
        arr = new int[N + 1];
        num = new int[N + 1];
        dist = new int[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
        	buildings[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = N; i >= 1; i--) {
        	while(!stack.isEmpty() && stack.peek()[1] <= buildings[i]) {
        		stack.poll();
        	}
        	
        	if(!stack.isEmpty()) {
        		int curDist = Math.abs(stack.peek()[0] - i);
        		
        		if(curDist <= dist[i]) {
        			num[i] = stack.peek()[0];
        			dist[i] = curDist;
        		}
        	}
        
        	arr[i] += stack.size();
        	
        	stack.push(new int[] {i, buildings[i]});
        }
        
        stack.clear();
        
        for(int i = 1; i <= N; i++) {
        	while(!stack.isEmpty() && stack.peek()[1] <= buildings[i]) {
        		stack.poll();
        	}
        	
        	
        	if(!stack.isEmpty()) {
        		int curDist = Math.abs(stack.peek()[0] - i);
        		
        		if(curDist <= dist[i]) {
        			num[i] = stack.peek()[0];
        			dist[i] = curDist;
        		}
        	}
        
        	arr[i] += stack.size();
        	
        	stack.push(new int[] {i, buildings[i]});
        }
        
        
        for(int i = 1; i <= N; i++) {
        	if(arr[i] == 0) 
        		System.out.println(arr[i]);
        	else
        		System.out.println(arr[i] + " " + num[i]);
        }

    }
}