class Solution {
    
    static int gcdA, gcdB;
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
            
        gcdA = arrayA[0];
        gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);       
        }
        
        for(int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if(gcdB != 0) {
            for(int i = 0; i < arrayA.length; i++) {
                if(arrayA[i] % gcdB == 0) {
                    gcdB = 0;
                    break;
                }
            }
        }
        
        if(gcdA != 0) {
            for(int i = 0; i < arrayB.length; i++) {
                if(arrayB[i] % gcdA == 0) {
                    gcdA = 0; 
                    break;
                }
            }
        }
        
        return Math.max(gcdA, gcdB);
    }
    
    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
}