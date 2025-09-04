import java.util.*;

class Solution {
    
    static List<File> list = new ArrayList<>();
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        for(int i = 0; i < files.length; i++) {
            String head = "", number = "";
            
            boolean isTail = false;
            
            for(int j = 0; j < files[i].length(); j++) {
                while(j < files[i].length() && 0 <= files[i].charAt(j) - '0' && files[i].charAt(j) - '0' <= 9)                 {                    
                    number += files[i].charAt(j);
                    j++;
                                        
                    isTail = true;
                }
                
                if(isTail) break;                    
                
                head += files[i].charAt(j);
            }
            
            list.add(new File(head.toUpperCase(), Integer.parseInt(number), i));
        }
        
        Collections.sort(list, (f1, f2) -> 
             f1.head.equals(f2.head) ? f1.number == f2.number ? f1.index - f2.index : f1.number - f2.number :               f1.head.compareTo(f2.head)
        );
         
        
        for(int i = 0; i < list.size(); i++) {
            int index = list.get(i).index;
            
            answer[i] = files[index];
        }
        
        return answer;
    }
    
    static class File {
        String head;
        int number;
        int index;
        
        File(String head, int number, int index) {
            this.head = head;
            this.number = number;
            this.index = index;
        }
    }
}