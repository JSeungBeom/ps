import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, T;
	static List<LinkedList<Integer>> circle = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	T = Integer.parseInt(st.nextToken());
    	
    	for(int i = 0; i < N; i++) {
    		circle.add(new LinkedList<>());
    	}
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		for(int j = 0; j < M; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			
    			circle.get(i).add(num);
    		}
    	}
    	
    	for(int i = 0; i < T; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int num = Integer.parseInt(st.nextToken());
    		int dir = Integer.parseInt(st.nextToken());
    		int count = Integer.parseInt(st.nextToken());
    		
    		rotate(num, dir, count);

    		
    		if(!erase()) {
    			adjustByAvg();
    		}
    	}
    	
    	System.out.println(getCircleSum());
    }
	
	static int getCircleSum() {
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int cur = circle.get(i).get(j);
				
				if(cur == -1) continue;

				sum += cur;
			}
		}
		
		return sum;
	}
	
	static void adjustByAvg() {
		double avg = getAvg();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int cur = circle.get(i).get(j);
				
				if(cur == -1) continue;

				if(cur > avg) circle.get(i).set(j, cur - 1);
				if(cur < avg) circle.get(i).set(j, cur + 1);
			}
		}
	}
	
	static double getAvg() {
		int sum = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(circle.get(i).get(j) == -1) continue;
				
				int cur = circle.get(i).get(j);
				sum += cur;
				cnt++;
			}
		}
		
		return (double)sum / (double) cnt;
	}
	
	static void rotate(int num, int dir, int count) {
		for(int i = num; i <= N; i += num) {
			for(int j = 0; j < count; j++) {
				if(dir == 0) {
					int last = circle.get(i - 1).pollLast();
					circle.get(i - 1).addFirst(last);
				}
				else {
					int first = circle.get(i - 1).pollFirst();
					circle.get(i - 1).addLast(first);
				}
			}
		}
	}
	
	static boolean erase() {
		boolean isErased = false;
		Set<String> erased = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int cur = circle.get(i).get(j);

				if(cur == -1) continue;
				
				List<int[]> nums = new ArrayList<>();
				boolean curErased = false;
				if(i == 0) {
					nums.add(new int[] {i + 1, j, getNumber(i + 1, j)});
				}
				else if(i == N - 1) {
					nums.add(new int[] {i - 1, j, getNumber(i - 1, j)});
				}
				else {
					nums.add(new int[] {i + 1, j, getNumber(i + 1, j)});
					nums.add(new int[] {i - 1, j, getNumber(i - 1, j)});
				}
				
				if(j == 0) {
					nums.add(new int[] {i, j + 1, getNumber(i, j + 1)});
					nums.add(new int[] {i, M - 1, getNumber(i, M - 1)});
				}
				else if(j == M - 1) {
					nums.add(new int[] {i, j - 1, getNumber(i, j - 1)});
					nums.add(new int[] {i, 0, getNumber(i, 0)});
				}
				else {
					nums.add(new int[] {i, j + 1, getNumber(i, j + 1)});
					nums.add(new int[] {i, j - 1, getNumber(i, j - 1)});
				}
				
				for(int[] num : nums) {
					if(cur == num[2]) {
						erased.add(num[0] + "," + num[1]);
						isErased = true;
						curErased = true;
					}
				}
				
				if(curErased) erased.add(i + "," + j);
			}
		}
		
		for(String cur : erased) {
			String[] idx = cur.split(",");
			
			int x = Integer.parseInt(idx[0]);
			int y = Integer.parseInt(idx[1]);
			
			circle.get(x).set(y, -1);
		}
		
		return isErased;
	}
	
	static int getNumber(int x, int y) {
		return circle.get(x).get(y);
	}
}