class Solution {
    
    static int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        board = new int[rows + 1][columns + 1];
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                board[i][j] = j + (i - 1) * columns;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            answer[i] = rotate(rows, columns, x1, y1, x2, y2);
        }
        
        
        return answer;
    }
    
    static int rotate(int rows, int columns, int x1, int y1, int x2, int y2) {
        int[][] temp = new int[rows + 1][columns + 1];
        int min = Integer.MAX_VALUE;
        
        // 위
        for(int i = x1; i < x2; i++) {
            temp[i][y1] = board[i + 1][y1];
        }
        
        // 오른쪽
        for(int i = y1; i < y2; i++) {
            temp[x2][i] = board[x2][i + 1];
        }
        
        // 아래
        for(int i = x2; i > x1; i--) {
            temp[i][y2] = board[i - 1][y2];
        }
        
        // 왼쪽
        for(int i = y2; i > y1; i--) {
            temp[x1][i] = board[x1][i - 1];
        }
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                if(temp[i][j] == 0) continue;
                
                board[i][j] = temp[i][j];
                min = Math.min(min, temp[i][j]);
            }
        }
        
        return min;
    }
}