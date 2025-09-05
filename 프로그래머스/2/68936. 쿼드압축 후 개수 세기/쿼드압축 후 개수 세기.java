class Solution {
    
    static int n, m;
    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        
        n = arr.length;
        m = arr[0].length;
        
        compress(0, 0, n, m, arr);
        
        return answer;
    }
    
    static void compress(int r1, int c1, int r2, int c2, int[][] arr) {
        if(r2 - r1 == 1 && c2 - c1 == 1) {
            if(arr[r1][c1] == 1) answer[1]++;
            else answer[0]++;
            
            return;
        }
        
        int num = arr[r1][c1];
        
        for(int i = r1; i < r2; i++) {
            for(int j = c1; j < c2; j++) {
                if(num != arr[i][j]) {
                    compress(r1, c1, (r1 + r2) / 2, (c1 + c2) / 2, arr); // 0 0 2 2
                    compress((r1 + r2) / 2, c1, r2, (c1 + c2) / 2, arr); // 1 2 0 1
                    compress(r1, (c1 + c2) / 2, (r1 + r2) / 2, c2, arr); // 0 2 2 4
                    compress((r1 + r2) / 2, (c1 + c2) / 2, r2, c2, arr); // 2 2 4 4
                    
                    return;
                }
            }
        }

        if(num == 1) answer[1]++;
        else answer[0]++;
    }
}