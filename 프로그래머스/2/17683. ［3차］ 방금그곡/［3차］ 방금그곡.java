import java.util.*;

class Solution {  
    
    static int max = 0;
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");
            String songName = musicinfo[2];
            String code = musicinfo[3];
            
            int startTime = toMinute(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            int endTime = toMinute(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
            int playTime = endTime - startTime;    
            
            String totalCode = calculateTotalCode(playTime, code);
            
            System.out.println(totalCode);
            
            List<String> codeList = makeCodeList(m);
            List<String> totalCodeList = makeCodeList(totalCode);
            
            if(checkTotalCode(codeList, totalCodeList)) {
                if(max < playTime) {
                    max = playTime;
                    answer = songName;
                }
            }
        }
        
        return answer;
    }
    
    static List<String> makeCodeList(String code) {
        List<String> codeList = new ArrayList<>();
        
        for(int i = 0; i < code.length(); i++) {
            StringBuilder sb = new StringBuilder();
            
            if(code.charAt(i) == '#') continue;
            if(i != code.length() - 1 && code.charAt(i + 1) == '#') {
                sb.append(code.charAt(i)); sb.append(code.charAt(i + 1));
            }
            else {
                sb.append(code.charAt(i));
            }
            
            codeList.add(sb.toString());
        }
        
        return codeList;
    }
    
    static int toMinute(int hour, int minute) {
        return (hour * 60) + minute;
    }
    
    static String calculateTotalCode(int playTime, String code) {
        StringBuilder sb = new StringBuilder();
       
        int i = 0;
        
        while(playTime != 0) {
            int index = (i % code.length());
            
            if(code.charAt(index) == '#') continue;
            if(index != code.length() - 1 && code.charAt(index + 1) == '#') {
                sb.append(code.charAt(index)); sb.append(code.charAt(index + 1)); i += 2;
            }
            else {
                sb.append(code.charAt(index)); i++;
            }
            
            playTime--;
        }
        
        return sb.toString();
    }
    
    static boolean checkTotalCode(List<String> codeList, List<String> totalCodeList) {
        int difference = totalCodeList.size() - codeList.size();
        if(difference < 0) return false;
        
        for(int start = 0; start <= difference; start++) {
            boolean isCorrect = true;
            for(int i = start; i < codeList.size() + start; i++) {
                if(!codeList.get(i - start).equals(totalCodeList.get(i))) {
                    isCorrect = false;
                }
            }
            
            if(isCorrect) return true;
        }
        
        return false;
    }
}