import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {        
        int answer = 0;
        
        Arrays.sort(stations);
        
        answer += getNumber(1, stations[0] - w - 1, w * 2 + 1);
        
        for(int i = 1; i < stations.length; i++){
            answer += getNumber(stations[i - 1] + w + 1, stations[i] - w - 1, w * 2 + 1);
        }
        
        answer += getNumber(stations[stations.length - 1] + w + 1, n, w * 2 + 1);
        
        return answer;
    }
    
    static int getNumber(int st, int en, int w) {
        int num = en - st + 1;
        
        if(num <= 0) return 0;
        
        if(num % w == 0) return num / w;
        else return num / w + 1;
    }
}