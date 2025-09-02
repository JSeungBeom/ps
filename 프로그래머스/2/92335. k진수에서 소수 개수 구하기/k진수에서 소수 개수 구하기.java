class Solution {
    
    static final int MAX = 10000000;
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String number = Integer.toString(n, k);
                
        String[] numbers = number.split("0");
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i].isBlank()) continue;
            long num = Long.parseLong(numbers[i]);
            
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long val) {
        if(val <= 1) return false;
        if (val == 2) return true;
        if ((val & 1) == 0) return false;
        
        for(long i = 3; i * i <= val; i++) {
            if(val % i == 0) return false;
        }
        
        return true;
    }
    

}