class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                int sum = 0;

                for(int k = 0; k < arr1[i].length; k++) {
                    sum += (arr1[i][k] * arr2[k][j]);
                }
                
                answer[i][j] = sum;
            }   
            
        }
        
        return answer;
    }
}

// 2 x 3, 3 x 5

// 3 3 3  3 3 3 3 3
// 3 3 3  3 3 3 3 3
//        3 3 3 3 3

// 2 3 2  5 4 3  22 
// 4 2 4  2 4 1  36
// 3 1 4  3 1 1

// 1 4   3 3  
// 3 2   3 3
// 4 1