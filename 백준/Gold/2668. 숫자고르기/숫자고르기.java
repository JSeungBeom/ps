import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, answer;
	static int[] arr;
	static boolean[] vis;
	static List<Integer> list = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N + 1];
        vis = new boolean[N + 1];
        
        for(int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 1; i <= N; i++) {
        	vis[i] = true;
        	dfs(i, i);
        	vis[i] = false;
        }
        
        System.out.println(list.size());
        
        for(int e : list) {
        	System.out.println(e);
        }
        
    }
    
    static void dfs(int start, int target) {
    	if(vis[arr[start]] == false) {
    		vis[arr[start]] = true;
    		dfs(arr[start], target);
    		vis[arr[start]] = false;
    	}
    	
    	if(arr[start] == target) {
    		list.add(target);
    	}
    }

}

// 1 2 3 4 5 6 7
// 3 2 1 5 6 4 7
