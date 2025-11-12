import java.io.*;
import java.util.*;

public class Main {

	static int R, C, N;
	static Bomb[][] board;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        board = new Bomb[R][C];
        
        for(int i = 0; i < R; i++) {
        	String s = br.readLine();
        	
        	for(int j = 0; j < C; j++) {
        		if(s.charAt(j) == 'O') {
        			board[i][j]	= new Bomb(true, 1);
        		}
        		else
        			board[i][j] = new Bomb(false, 0);
        	}
        }
        
        if(N <= 1) {
        	printBoard(); return;
        }
        
        N -= 1;
        
        for(int i = 0; i < N; i++) {
        	increaseBomb();
        	
        	if(i % 2 == 0) 
        		putBomb();
        	else
        		explode();
        }
        
        printBoard();
        
    }
    
    static void explode() {
    	boolean[][] tmp = new boolean[R][C];
    	
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			if(board[i][j].count == 3) {
    				for(int dir = 0; dir < 4; dir++) {
    					int nx = i + dx[dir];
    					int ny = j + dy[dir];
    					
    					if(OOB(nx, ny)) continue;
    					
    					tmp[nx][ny] = true;
    				}
    				
    				tmp[i][j] = true;
    			}
    		}
    	}
    	
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			if(tmp[i][j]) {
    				board[i][j] = new Bomb(false, 0);
    			}
    		}
    	}
    }
    
    static boolean OOB(int x, int y) { 
    	return x < 0 || x >= R || y < 0 || y >= C;
    }
    
    static void increaseBomb() {
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			if(board[i][j].isPresent) {
    				board[i][j].count = board[i][j].count + 1;
    			}
    		}
    	}
    }
    
    static void putBomb() {
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			if(board[i][j].isPresent) continue;
    			
    			board[i][j] = new Bomb(true, 0);
    		}
    	}
    }
    
    static void printBoard() {
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			if(board[i][j].isPresent) {
    				System.out.print('O');
    			}
    			else
    				System.out.print('.');
    		}
    		System.out.println();
    	}
    }
    
    static class Bomb {
    	boolean isPresent;
    	int count;
    	
    	Bomb(boolean isPresent, int count) {
    		this.isPresent = isPresent;
    		this.count = count;
    	}

		@Override
		public String toString() {
			return isPresent + ", " + count;
		}
    }
}
