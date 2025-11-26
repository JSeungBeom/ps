import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int answer;
	static int[][] board;
	static ChessList[][] chessList;
	static List<Chess> list = new ArrayList<>();
	static boolean isCompleted;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	board = new int[N][N];
    	chessList = new ChessList[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			chessList[i][j] = new ChessList();
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0; i < K; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int dir = Integer.parseInt(st.nextToken());
    		
    		Chess chess = new Chess(x - 1, y - 1, dir - 1);
    		
    		list.add(chess);
    		chessList[x - 1][y - 1].addChess(chess);
    	}
    	
    	while(true) {
    		answer++; 
    		
			
    		for(int i = 0; i < list.size(); i++) {
    			move(list.get(i));
    			
    			
    			if(isCompleted) {
    				System.out.println(answer);
    				return;
    			}
    		}
    		

    		
    		if(answer > 1000) {
    			System.out.println(-1); return;
    		}
    	}
    }
    
    static void move(Chess chess) {
    	int x = chess.x;
    	int y = chess.y;
    	int dir = chess.dir;
    	
    	int nx = x + dx[dir];
    	int ny = y + dy[dir];
    	
    	if(OOB(nx, ny)) {
    		dir = reverse(dir);
        	chess.dir = dir;

    		nx = x + dx[dir];
    		ny = y + dy[dir];
    		
    		if(OOB(nx, ny)) return;
    	}
    	
    	List<Chess> chesses = chessList[x][y].chessList;
    	List<Chess> added = new ArrayList<>();
    	int idx = chesses.indexOf(chess);
    	
    	for(int i = idx; i < chesses.size(); i++) {
    		chesses.get(i).x = nx;
    		chesses.get(i).y = ny;
    		
    		added.add(chesses.get(i));
    	}
    	
    	
    	if(board[nx][ny] == 0) {
    		chessList[nx][ny].addChesses(added);
    		chessList[x][y].removeChesses(added);
    	}
    	else {
    		Collections.reverse(added);
    		chessList[nx][ny].addChesses(added);
    		chessList[x][y].removeChesses(added);
    	}
    	
    	if(checkBoard(chessList[nx][ny].chessList)) {
    		isCompleted = true;
    	}
    }
    
    static int reverse(int dir) {
    	if(dir % 2 == 1)
    		return dir - 1;
    	
    	return dir + 1;
    }
    
    static boolean checkBoard(List<Chess> chesses) {
    	return chesses.size() >= 4;
    }
    
    static boolean OOB(int x, int y) {
    	return x < 0 || x >= N || y < 0 || y >= N || board[x][y] == 2;
    }
    
    static class Chess {
    	int x;
    	int y;
    	int dir;
    	
    	Chess(int x, int y, int dir) {
    		this.x = x;
    		this.y = y;
    		this.dir = dir;
    	}
    	
    	@Override
    	public String toString() {
    		return "[x : " + x + " y : " + y + " dir : " + dir + "]";
    	}
    }
    
    static class ChessList {
    	List<Chess> chessList = new ArrayList<>();
    	
    	void addChess(Chess chess) {
    		chessList.add(chess);
    	}
    	
    	void addChesses(List<Chess> chesses) {
    		for(int i = 0; i < chesses.size(); i++) {
    			chessList.add(chesses.get(i));
    		}
    	}
    	
    	void removeChesses(List<Chess> chesses) {
    		for(int i = 0; i < chesses.size(); i++) {
    			chessList.remove(chesses.get(i));
    		}
    	}
    	
    }
}

