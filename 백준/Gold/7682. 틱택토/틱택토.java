import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static String tc;
	static char[][] board = new char[3][3];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	tc = br.readLine();
        	
        	if(tc.equals("end")) break;
        	
        	for(int i = 0; i < 3; i++) {
        		for(int j = 0; j < 3; j++) {
        			board[i][j] = tc.charAt(i * 3 + j);
        		}
        	}
        
        	int xNum = checkNum('X');
        	int oNum = checkNum('O');
        	
        	if(xNum != oNum && xNum - 1 != oNum) {
        		System.out.println("invalid");
        		continue;
        	}
        	
        	boolean xWin = checkWin('X');
        	boolean oWin = checkWin('O');
        	
        	
        	if(xWin && oWin) {
        		System.out.println("invalid");
        		continue;
        	}
        
        	if(xWin) {
        		if(xNum - 1 == oNum)
        			System.out.println("valid"); 
        		else
        			System.out.println("invalid");
        		continue;
        	}
        	
        	if(oWin) {
        		if(xNum == oNum)
        			System.out.println("valid"); 
        		else
        			System.out.println("invalid");
        		continue;
        	}
        		
        	if(checkFull()) {
        		System.out.println("valid");
        	} else {
        		System.out.println("invalid");
        	}
        }
    }
    
    static boolean checkFull() {
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			if(board[i][j] == '.') return false;
    		}
    	}
    	
    	return true;
    }
    
    static int checkNum(char type) {
    	int num = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			if(board[i][j] == type) num++; 
    		}
    	}
    	
    	return num;
    }
    
    static boolean checkWin(char type) {
    	// 가로
    	for(int i = 0; i < 3; i++) {
    		int num = 0;
    
    		for(int j = 0; j < 3; j++) {
    			if(board[i][j] == type) {
    				num++;
    			}
    			
    			if(num == 3) return true;
    		}
    	}
    	
    	// 세로
    	for(int i = 0; i < 3; i++) {
    		int num = 0;
    
    		for(int j = 0; j < 3; j++) {
    			if(board[j][i] == type) {
    				num++;
    			}
    			
    			if(num == 3) return true;
    		}
    	}
    	
    	// 대각선 1
    	int num1 = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		if(board[i][i] == type) num1++;
    	}
    	
    	if(num1 == 3) return true;
    	
    	// 대각선 2
    	int num2 = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		if(board[i][3 - i - 1] == type) num2++;
    	}
    	
    	if(num2 == 3) return true;
    	
    	return false;
    }
}

// 1. 수가 다른 경우
// 2. 한 쪽이 이긴 경우
// 3. 양 쪽 모두 이긴 경우
// 4. 아무도 이기지 못한 경우

