import java.util.*;

class Solution {
    
    static List<List<Integer>> crews = new ArrayList<>(); 
    
    public String solution(int n, int t, int m, String[] timetable) {
        int[] arr = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] cur = timetable[i].split(":");
            arr[i] = toMinute(Integer.parseInt(cur[0]), Integer.parseInt(cur[1]));
        }
        
        Arrays.sort(arr);

        int idx = 0;                     
        int depart0 = toMinute(9, 0);     
        int lastBoarded = -1;             
        int boardAtLastBus = 0;           

        for (int k = 0; k < n; k++) {
            int depart = depart0 + k * t; 
            int boarded = 0;              

            while (idx < arr.length && arr[idx] <= depart && boarded < m) {
                if (k == n - 1) lastBoarded = arr[idx]; 
                idx++;
                boarded++;
            }

            if (k == n - 1) boardAtLastBus = boarded;   
        }

        int lastDepart = depart0 + (n - 1) * t;
        int answerMinute = (boardAtLastBus < m) ? lastDepart : Math.max(0, lastBoarded - 1);

        return toTime(answerMinute);
    }

    
    static int toMinute(int hour, int minute) {
        return hour * 60 + minute;
    }
    
    static String toTime(int minute) {
        int hour = minute / 60;
        int min = minute % 60;
        
        String strHour = hour >= 0 && hour <= 9 ? "0" + hour : String.valueOf(hour);
        String strMinute = min >= 0 && min <= 9 ? "0" + min : String.valueOf(min);
        
        return strHour + ":" + strMinute;
    }
}

// 자리가 빈 경우 -> 
// 자리가 없는 경우