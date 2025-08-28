class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
                
        return answer;
    }
    
    static int gcd(int a, int b){
        if(a == 0) return b;
        
        return gcd(b % a, a);
    }
    
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}