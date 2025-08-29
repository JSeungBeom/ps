class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        
        int[] answer = new int[size];

        for(long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
                        
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        } 
        
        return answer;
    }
} 

// 1 2 3 4 5
// 2 2 3 4 5
// 3 3 3 4 5
// 4 4 4 4 5
// 5 5 5 5 5

// 1 2 3 2 2 3 3 3 3 