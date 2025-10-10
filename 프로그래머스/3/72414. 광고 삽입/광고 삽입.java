class Solution {
    
    static long[] time;
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playTime = timeToSec(play_time);
        int advTime = timeToSec(adv_time);
        
        time = new long[playTime + 1];
        
        for(String log : logs) {
            String[] arr = log.split("-");
            
            int startTime = timeToSec(arr[0]);
            int endTime = timeToSec(arr[1]);
            
            time[startTime] += 1;
            time[endTime] -= 1;
        }
        
        for(int i = 1; i <= playTime; i++) {
            time[i] += time[i - 1];
        }
        
        for(int i = 1; i <= playTime; i++) {
            time[i] += time[i - 1];            
        }
        
        long max = time[advTime];
        int start = 0;
        
        for(int i = 1; i <= playTime - advTime; i++) {
            long cur = time[i + advTime - 1] - time[i - 1];
            
            if(cur > max) {
                max = cur;
                start = i;
            }
        }
        
        
        
        return secToTime(start);
    }
    
    static int timeToSec(String s) {
        String[] ss = s.split(":");
        
        return Integer.parseInt(ss[0]) * 60 * 60 + Integer.parseInt(ss[1]) * 60 + 
            Integer.parseInt(ss[2]);
    }
    
    static String secToTime(int sec) {
        int hour = sec / (60 * 60);
        sec %= (60 * 60);
        int minute = sec / 60;
        int second = sec % 60;
        
        String h = hour >= 10 ? String.valueOf(hour) : "0" + hour;
        String m = minute >= 10 ? String.valueOf(minute) : "0" + minute;
        String s = second >= 10 ? String.valueOf(second) : "0" + second;

        return h + ":" + m + ":" + s;
    }
}