class Solution {
    
    static int[] rowColumns;
    static int answer;
    
    public int solution(int n) {
        rowColumns = new int[n];
        
        dfs(0, n);
        
        return answer;
    }
    
    static void dfs(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            rowColumns[row] = i;
            
            if(chk(row)) 
                dfs(row + 1, n);
        }
    }
    
    static boolean chk(int row) {
        for(int i = 0; i < row; i++) {
            if(rowColumns[i] == rowColumns[row]) return false;
            
            if(Math.abs(i - row) == Math.abs(rowColumns[i] - rowColumns[row])) return false;
        }
        
        return true;
    }
}