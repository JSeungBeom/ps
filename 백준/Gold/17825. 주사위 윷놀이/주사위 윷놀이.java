import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dices = new int[10];
	static int[] red = new int[21];
	static int[][] blue = new int[][]{
			 { 0 },
			 { 10, 13, 16, 19, 25, 30, 35, 40 }, 
			 { 20, 22, 24, 25, 30, 35, 40 },
			 { 30, 28, 27, 26, 25, 30, 35, 40 }
			};
	static int[] arr = new int[10];
	static Piece[] pieces = new Piece[4];
	static int answer;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < 10; i++) {
    		dices[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 0; i <= 20; i++) {
    		red[i] = i * 2;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		pieces[i] = new Piece(i, 0);
    	}
    	
    	
    	perm(0);
    	
    	System.out.println(answer);
    }
    
    static void perm(int N) {
    	if(N == 10) {
        	for(int i = 0; i < 4; i++) {
        		pieces[i] = new Piece(i, 0);
        	}
        	
//        	for(int i = 0; i < 10; i++) {
//        		System.out.print(arr[i] + " ");
//        	}
//        	
//        	System.out.println();
        	
    		answer = Math.max(answer, move());
    		return;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		arr[N] = i;
    		perm(N + 1);
    	}
    }
    
    static int move() {
    	int sum = 0;	
    	
    	for(int i = 0; i < 10; i++) {
    		int dice = dices[i];
    		    		
    		if(pieces[arr[i]].isDeparted) return 0;
    		
    		switch(pieces[arr[i]].lane) {
    			case 0:
    				pieces[arr[i]].position += dice;
    				int curPos = pieces[arr[i]].position;
    				if(curPos > 20) {
    					pieces[arr[i]].isDeparted = true;
    					break;
    				}

    				sum += red[curPos];
    				
    				if(curPos % 5 == 0 && curPos != 20) {
    					pieces[arr[i]].lane = curPos / 5;
    					pieces[arr[i]].position = 0;
    				}
    				
    				if(checkPos(pieces[arr[i]])) return 0;
    				
    				break;
				default:
					pieces[arr[i]].position += dice;
					curPos = pieces[arr[i]].position;
					int curLane = pieces[arr[i]].lane;
					if(curPos >= blue[curLane].length) {
						pieces[arr[i]].isDeparted = true;
						break;
					}
					
    				if(checkPos(pieces[arr[i]])) return 0;
					
					sum += blue[curLane][curPos];
					break;
    		}
    		
    	}
    	
    	
    	return sum;
    }
    
    static boolean checkPos(Piece piece) {
    	if(piece.isDeparted) return false;
    	
    	int curScore, tgtScore;
    	
    	for(int i = 0; i < 4; i++) {
    		if(i == piece.order) continue;
    		if(piece.isDeparted || pieces[i].isDeparted) continue;
    		
    		switch(piece.lane) {
    			case 0: 
    				curScore = red[piece.position]; break;
				default:
					curScore = blue[piece.lane][piece.position]; break;
    		}
    		
    		switch(pieces[i].lane) {
				case 0: 
					tgtScore = red[pieces[i].position]; break;
				default:
					tgtScore = blue[pieces[i].lane][pieces[i].position]; break;
    		}
    			
    		
    		if(curScore != 0 && curScore == tgtScore) {
    			if(curScore == 16 || curScore == 22 || curScore == 24 || curScore == 26 || curScore == 28 || curScore == 30) {
    	    		if(piece.lane == pieces[i].lane && piece.position == pieces[i].position) 
    	    			return true;
    			}
	    		else {
	    			return true;
	    		}
    		}
    	}
    	
    	return false;
    }
    
    
    
    static class Piece {
    	int order;
    	int position;
    	int lane;
    	boolean isDeparted = false;
    	
    	Piece(int order, int position) {
    		this.order = order;
    		this.position = position;
    	}

		@Override
		public String toString() {
			return "Piece [order=" + order + ", position=" + position + ", lane=" + lane + ", isDeparted=" + isDeparted
					+ "]";
		}
    	
    }

}