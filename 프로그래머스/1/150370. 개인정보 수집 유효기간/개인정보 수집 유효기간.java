import java.util.*;

class Solution {
    
    static HashMap<String, Integer> expiredDate = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] now = today.split("\\.");
              
        int cur = 
            toDay(Integer.parseInt(now[0]), Integer.parseInt(now[1]), Integer.parseInt(now[2]));
        
        for(int i = 0; i < terms.length; i++) {
            String[] arr = terms[i].split(" ");
            
            expiredDate.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            
            String[] date = arr[0].split("\\.");
            
            int day =
                toDay(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            day += toDay(expiredDate.get(arr[1]));
                        
            if(day <= cur) answer.add(i + 1);            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }

    static int toDay(int month) {
        return month * 28;
    }
    
    static int toDay(int year, int month, int day) {
        return year * 12 * 28 + month * 28 + day;
    }
}