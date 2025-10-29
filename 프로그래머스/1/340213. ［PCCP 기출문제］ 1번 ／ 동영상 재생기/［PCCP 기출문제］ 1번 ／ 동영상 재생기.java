class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int len = toSecond(video_len);
        int cur = toSecond(pos);
        int start = toSecond(op_start);
        int end = toSecond(op_end);
        
        cur = checkOp(cur, start, end);
        
        for(int i = 0; i < commands.length; i++) {
            if("next".equals(commands[i])) {
                cur += 10;
                cur = adjustTime(cur, len);
                cur = checkOp(cur, start, end);
            }
            
            if("prev".equals(commands[i])) {
                cur -= 10;
                cur = adjustTime(cur, len);
                cur = checkOp(cur, start, end);
            }
        }
        
        return toTime(cur);
    }
    
    static String toTime(int second) {
        int minute = second / 60;
        int sec = second % 60;
        
        String min = minute < 10 ? "0" + minute : String.valueOf(minute);
        String sex = sec < 10 ? "0" + sec : String.valueOf(sec);
        
        return min + ":" + sex;
    }
    
    static int toSecond(String time) {
        String[] times = time.split(":");
        
        int minute = Integer.parseInt(times[0]);
        int second = Integer.parseInt(times[1]);
        
        return minute * 60 + second;
    }
    
    static int adjustTime(int cur, int len) {
        if(cur >= len)
            return len;
        
        if(cur <= 0)
            return 0;
        
        return cur;
    }
    
    static int checkOp(int cur, int start, int end) {
        return start <= cur && cur <= end ? end : cur;
    }
}