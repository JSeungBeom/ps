import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n = A.length;
        
        int idxA = n - 1;
        int idxB = n - 1;
        
        while(true) {
            while(A[idxA] >= B[idxB]){
                idxA--;
                
                if(idxA < 0)
                    return answer;
            }
            
            answer++;
            
            
            idxA--;
            idxB--;
            
            if(idxA < 0 || idxB < 0) return answer;
        }
    }
}