import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int t;
	static int r, c, k;
	static int[][] board = new int[105][105];
	static int rowSize = 3, colSize = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(board[r][c] != k && t <= 100) {
			t++;
			
			reorderArray();
			
		}
		
		if(t <= 100) 
			System.out.println(t);
		else 
			System.out.println(-1);
	}
	
	static void reorderArray() {		
		if(rowSize >= colSize) {
			sortRow();
		}
		else {
			sortColumn();
		}
		
		if(rowSize > 100) rowSize = 100;
		if(colSize > 100) colSize = 100;
	}

	static void sortColumn() {
		int max = 0;
		
		for(int i = 1; i <= colSize; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

			int idx = 1;
			
			for(int j = 1; j <= rowSize; j++) {
				if(board[j][i] == 0) continue;
				
				map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
			}
			
			for(int num : map.keySet()) {
				pq.add(new int[] {num, map.get(num)});
			}
			
			for(int j = 1; j <= 100; j++) {
				board[j][i] = 0;
			}
			
			for(int j = 1; j <= map.size() * 2 - 1; j += 2) {
				int[] cur = pq.poll();
				
				board[j][i] = cur[0];
				board[j + 1][i] = cur[1];
			}
			
			max = Math.max(max, map.size() * 2);
		}
		
		rowSize = max;
	}

	static void sortRow() {
		int max = 0;
		
		for(int i = 1; i <= rowSize; i++) {
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));
			Map<Integer, Integer> map = new HashMap<>();
			
			for(int j = 1; j <= colSize; j++) {
				if(board[i][j] == 0) continue;
				
				map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
			}
			
			for(int num : map.keySet()) {
				pq.add(new int[] {num, map.get(num)});
			}
			
			Arrays.fill(board[i], 0);
			
			for(int j = 1; j <= map.size() * 2 - 1; j+= 2) {
				int[] cur = pq.poll();
				
				board[i][j] = cur[0];
				board[i][j + 1] = cur[1];
			}
			
			max = Math.max(max, map.size() * 2);
		}
		
		colSize = max;
		
		
	}
}