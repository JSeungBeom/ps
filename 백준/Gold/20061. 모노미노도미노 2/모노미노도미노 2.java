import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean[][] blue = new boolean[4][6];
	static boolean[][] red = new boolean[6][4];
	static int score;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	N = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());

	    	int t = Integer.parseInt(st.nextToken());
	    	int x = Integer.parseInt(st.nextToken());
	    	int y = Integer.parseInt(st.nextToken());
	    	
	    	move(t, x, y);
	    	disappear();
	    	checkSpecial();
	    	
    	}
    	
    	System.out.println(score);
    	System.out.println(countTile());
    	
    }
	
	static int countTile() {
		int cnt = 0;
		
		for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				cnt = blue[j][i] ? cnt + 1 : cnt;
				cnt = red[i][j] ? cnt + 1 : cnt;
			}
		}
		
		return cnt;
	}
	
	static void checkSpecial() {
		// blue
		int cntBlue = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				if(blue[j][i]) {
					cntBlue++;
					break;
				}
			}
		}
		
		for(int i = 5; i > 5 - cntBlue; i--) {
			for(int j = 0; j < 4; j++) {
				blue[j][i] = false;
			}
		}
		
		for(int i = 5 - cntBlue; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				blue[j][i + cntBlue] = blue[j][i];
			}
		}
		
		// red
		int cntRed = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				if(red[i][j]) {
					cntRed++;
					break;
				}
			}
		}
		
		for(int i = 5; i > 5 - cntRed; i--) {
			for(int j = 0; j < 4; j++) {
				red[i][j] = false;
			}
		}
		
		for(int i = 5 - cntRed; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				red[i + cntRed][j] = red[i][j];
			}
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				blue[j][i] = false;
				red[i][j] = false;
			}
		}
	}
	
	static void disappear() {
		// blue
		int cntBlue = 0;
		int idxBlue = -1;
		
		for(int i = 5; i >= 2; i--) {
			boolean isErased = true;
			for(int j = 0; j < 4; j++) {
				if(!blue[j][i]) {
					isErased = false;
					break; 
				}
			}
			
			if(isErased) {
				for(int j = 0; j < 4; j++) {
					blue[j][i] = false;
				}
				
				cntBlue++;
				idxBlue = i;
			}
		}
		
		for(int i = idxBlue - 1; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				blue[j][i + cntBlue] = blue[j][i];
			}
		}
		
		// red
		int cntRed = 0;
		int idxRed = -1;
		
		for(int i = 5; i >= 2; i--) {
			boolean isErased = true;
			for(int j = 0; j < 4; j++) {
				if(!red[i][j]) {
					isErased = false;
					break; 
				}
			}
			
			if(isErased) {
				for(int j = 0; j < 4; j++) {
					red[i][j] = false;
				}
				
				cntRed++;
				idxRed = i;
			}
		}
		
		for(int i = idxRed - 1; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				red[i + cntRed][j] = red[i][j];
			}
		}
		
		score += (cntRed + cntBlue);
	}
	
	static void move(int t, int x, int y) {
		if(t == 1) { // 1 x 1
			// blue
			for(int i = 0; i < 6; i++) {
				if(i == 5 || blue[x][i + 1] == true) {
					blue[x][i] = true; break;
				}
			}
			
			// red
			for(int i = 0; i < 6; i++) {
				if(i == 5 || red[i + 1][y] == true) {
					red[i][y] = true; break;
				}
			}
		}
		else if(t == 2) { // 1 x 2
			// blue
			for(int i = 0; i < 6; i++) {
				if(i == 4 || blue[x][i + 2] == true) {
					blue[x][i] = true; 
					blue[x][i + 1] = true;
					break;
				}
			}
			
			// red
			for(int i = 0; i < 6; i++) {
				if(i == 5 || red[i + 1][y] == true || red[i + 1][y + 1] == true) {
					red[i][y] = true;
					red[i][y + 1] = true;
					break;
				}
			}
		}
		else { // 2 x 1
			// blue
			for(int i = 0; i < 6; i++) {
				if(i == 5 || blue[x][i + 1] == true || blue[x + 1][i + 1] == true) {
					blue[x][i] = true; 
					blue[x + 1][i] = true;
					break;
				}
			}
			
			// red
			for(int i = 0; i < 6; i++) {
				if(i == 4 || red[i + 2][y] == true) {
					red[i][y] = true;
					red[i + 1][y] = true;
					break;
				}
			}
		}
	}
	
}