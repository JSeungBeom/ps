import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] time;
	static int[] indegree;
	static int[] answer;
	static List<List<Integer>> adj = new ArrayList<>();
	static Queue<int[]> queue = new ArrayDeque<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        
        time = new int[N + 1];
        indegree = new int[N + 1];
        answer = new int[N + 1];
        
        for(int i = 0; i <= N; i++) {
        	adj.add(new ArrayList<>());
        }
        
        
        
        for(int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	time[i] = Integer.parseInt(st.nextToken());
        	
        	while(true) {
        		int cur = Integer.parseInt(st.nextToken());
        		
        		if(cur == -1) break;

        		indegree[i]++;

        		adj.get(cur).add(i);
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	if(indegree[i] == 0) {
        		queue.offer(new int[] {i, time[i]});
        		answer[i] = time[i];
        	}
        }
        
        while(!queue.isEmpty()) {
        	int[] cur = queue.poll();
        	int building = cur[0];
        	int t = cur[1];
        	
        	for(int nxt : adj.get(building)) {
        		indegree[nxt]--;
        		
        		answer[nxt] = Math.max(answer[nxt], t + time[nxt]);
        		
        		if(indegree[nxt] == 0) {
        			queue.offer(new int[] {nxt, answer[nxt]});
        		}
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	System.out.println(answer[i]);
        }
    }

}
