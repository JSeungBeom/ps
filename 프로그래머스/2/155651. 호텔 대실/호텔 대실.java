import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[][] minutes;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        minutes = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            minutes[i][0] = convertToMinutes(book_time[i][0]);
            minutes[i][1] = convertToMinutes(book_time[i][1]);        
        }
        
        Arrays.sort(minutes, (m1, m2) -> (m1[0] - m2[0]));
        
        for(int i = 0; i < minutes.length; i++) {
            if(!pq.isEmpty() && pq.peek() + 10 <= minutes[i][0]) {
                pq.poll();
            }
            
            pq.add(minutes[i][1]);
        }
        
        
        return pq.size();
    }
    
    static int convertToMinutes(String time) {
        String[] hourMinutes = time.split(":");
        
        int hour = Integer.parseInt(hourMinutes[0]);
        int minute = Integer.parseInt(hourMinutes[1]);
        
        return hour * 60 + minute;
    }
}