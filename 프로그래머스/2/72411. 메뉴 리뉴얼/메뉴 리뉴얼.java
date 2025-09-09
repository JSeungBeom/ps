import java.util.*;

class Solution {
    
    static boolean[] select;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        
        for(int i = 0; i < orders.length; i++) {
            select = new boolean[orders[i].length()];
            
            char[] arr = orders[i].toCharArray();
            
            Arrays.sort(arr);
            
            subset(0, String.valueOf(arr), select);
        }
        
        for(int i = 0; i < course.length; i++) {
            int max = 0;
            
            for(String key : map.keySet()) {
                if(key.length() == course[i] && map.get(key) >= 2) {
                    max = Math.max(max, map.get(key));
                }    
            }
            
            for(String key : map.keySet()) {
                if(key.length() == course[i] && map.get(key) == max) {
                    list.add(key);
                }
            }
        }

        Collections.sort(list);
        
        answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
         
        
        return answer;
    }
    
    static void subset(int k, String menu, boolean[] select) {
        if(k == select.length) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < k; i++) {
                if(select[i]) {
                    sb.append(menu.charAt(i));
                }    
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    
            return;
        }
        
        select[k] = true;
        subset(k + 1, menu, select);
        
        select[k] = false;
        subset(k + 1, menu, select);
    }
}