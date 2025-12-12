import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board = new int[9][9];
	static boolean isComplished = false;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 9; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < 9; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        solve(0, 0);
        
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		System.out.print(board[i][j] + " ");
        	}
        	System.out.println();
        }
    }
    
    static void solve(int x, int y) {
    	if(isComplished) return;
    	
    	if(x == 9) {
    		isComplished = true;
    		return;
    	}
    	
    	if(board[x][y] != 0) {
    		if(y == 8)
    			solve(x + 1, 0);
    		else
    			solve(x, y + 1);
    		
    		return;
    	}
    	
    	boolean[] vis = new boolean[10];
    	
    	int stX = (x / 3) * 3;
    	int stY = (y / 3) * 3;
    	
    	for(int i = 0; i < 9; i++) {
    		vis[board[x][i]] = true;
    		vis[board[i][y]] = true;
    	}
    	
    	for(int i = stX; i < stX + 3; i++) {
    		for(int j = stY; j < stY + 3; j++) {
    			vis[board[i][j]] = true;
    		}
    	}
    	
    	for(int i = 1; i <= 9; i++) {
    		if(vis[i]) continue;
    		
    		board[x][y] = i;
    		if(y == 8)
    			solve(x + 1, 0);
    		else
    			solve(x, y + 1);
    		
    		if(isComplished) return;
    		board[x][y] = 0;
    	}
    }
}