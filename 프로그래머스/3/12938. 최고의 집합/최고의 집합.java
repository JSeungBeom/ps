class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int num = s / n;
        int mod = s % n;
        
        if(num == 0){
            return new int[] {-1};
        }
        else{
            for(int i = 0; i < n - mod; i++){
                answer[i] = num;
            }
            
            for(int i = n - mod; i < n; i++){
                answer[i] = num + 1;
            }
        }
        
        
        
        return answer;
    }
}