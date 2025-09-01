import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L;
	static int[][] board;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			boolean[] check = new boolean[N];
			boolean isCrossable = true;
			
			int cur = board[i][0];
			
			for(int j = 1; j < N; j++) {
				if(Math.abs(cur - board[i][j]) > 1) {
					isCrossable = false;
					break;
				}
				
				if(cur - board[i][j] == 1) {
					for(int k = j; k < j + L; k++) {
						if(k >= N || check[k] || cur - board[i][k] != 1) {
							isCrossable = false;
							break;
						}
						
						check[k] = true;
					}
					
					cur = board[i][j];
				}
				else if(cur - board[i][j] == -1) {
					cur = board[i][j];
					for(int k = j - 1; k > j - L - 1; k--) {
						if(k < 0 || check[k] || cur - board[i][k] != 1) {
							isCrossable = false;
							break;
						}
 
						check[k] = true;
					}
				}
				
				if(!isCrossable) break;
			}
			
			if(isCrossable) {
				answer++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			boolean[] check = new boolean[N];
			boolean isCrossable = true;
			
			int cur = board[0][i];
			
			for(int j = 1; j < N; j++) {
				if(Math.abs(cur - board[j][i]) > 1) {
					isCrossable = false;
					break;
				}
				
				if(cur - board[j][i] == 1) {
					for(int k = j; k < j + L; k++) {
						if(k >= N || check[k] || cur - board[k][i] != 1) {
							isCrossable = false;
							break;
						}
						
						check[k] = true;
					}
					
					cur = board[j][i];
				}
				else if(cur - board[j][i] == -1) {
					cur = board[j][i];
					for(int k = j - 1; k > j - L - 1; k--) {
						if(k < 0 || check[k] || cur - board[k][i] != 1) {
							isCrossable = false;
							break;
						}
 
						check[k] = true;
					}
				}
				
				if(!isCrossable) break;
			}
			
			if(isCrossable) {
				answer++;
			}
		}
		
		
		
		System.out.println(answer);
	}
	
}