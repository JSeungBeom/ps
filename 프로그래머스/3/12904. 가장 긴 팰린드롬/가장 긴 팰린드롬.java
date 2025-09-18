class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        int n = s.length();
        
        for(int mid = 0; mid < n; mid++) {
            int l = mid; int r = mid;
            
            while(l - 1 >= 0 && r + 1 < n) {
                if(s.charAt(l - 1) != s.charAt(r + 1)) break;
                l--; r++;
            }
            
            answer = Math.max(answer, r - l + 1);
        }
        
        for(int mid = 0; mid + 1 < n; mid++) {
            int l = mid; int r = mid + 1;
            
            while(l >= 0 && r < n) {
                if(s.charAt(l) != s.charAt(r)) break;
                
                l--; r++;
            }
            
            answer = Math.max(answer, r - l - 1);
        }
        
        return answer;
    }
}