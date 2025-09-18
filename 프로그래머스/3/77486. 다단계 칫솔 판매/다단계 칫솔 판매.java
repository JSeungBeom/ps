import java.util.*;

class Solution {
    
    static Map<Integer, String> itos = new HashMap<>();
    static Map<String, Integer> stoi = new HashMap<>();
    
    static int[] p;
    static List<List<Integer>> childList = new ArrayList<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        p = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) {
            childList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < enroll.length; i++) {
            itos.put(i, enroll[i]);
            stoi.put(enroll[i], i);
        }
        
        for(int i = 0; i < p.length; i++) {
            p[i] = -1;
        }
        
        for(int i = 0; i < referral.length; i++) {
            if(referral[i].equals("-")) continue;
            
            int a = stoi.get(enroll[i]);
            int b = stoi.get(referral[i]);
            
            childList.get(b).add(a);
            p[a] = b;
        }

        
        for(int i = 0; i < seller.length; i++) {
            int cur = stoi.get(seller[i]);
            long price = amount[i] * 100L;
            
            if(price == 0L) continue;
            
            while(cur != -1 && price > 0) {
                long pass = price / 10;
                long keep = price - pass;
                
                answer[cur] += (int) keep;
                cur = p[cur];
                price = pass;
            }
            
        }
        
        return answer;
    }
}