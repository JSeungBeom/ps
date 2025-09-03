import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    static TreeMap<String, Integer> treeMap = new TreeMap<>();
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(int[] fees, String[] records) {
        int baseHour = fees[0];
        int baseFee = fees[1];
        int unitHour = fees[2];
        int unitFee = fees[3];
        
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            String[] time = record[0].split(":");
            String carNumber = record[1];
            String inOut = record[2];
            
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            
            int totalMinute = toMinute(hour, minute);
            
            switch(inOut) {
                case "IN" :
                    map.put(carNumber, totalMinute);
                    break;
                    
                case "OUT" :
                    treeMap.put(
                        carNumber,
                        treeMap.getOrDefault(carNumber, 0) + totalMinute - map.get(carNumber)
                    );
                    map.remove(carNumber);
                    break;
            }
        }
        
        for(String carNumber : map.keySet()) {
            treeMap.put(
                carNumber,
                treeMap.getOrDefault(carNumber, 0) + toMinute(23, 59) - map.get(carNumber)
            );
        }            
        
        
        for(String carNumber : treeMap.keySet()) {            
            int usedHour = treeMap.get(carNumber);
            
            if(usedHour <= baseHour) {
                answer.add(baseFee);
            }
            else {
                System.out.println((int)Math.ceil(((double)usedHour - (double)baseHour) / (double)unitHour));
                int calculatedFee = baseFee + (int)Math.ceil(((double)usedHour - (double)baseHour) / (double)unitHour) * unitFee;
                answer.add(calculatedFee);
            }
        }         
        
        return answer
            .stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    static int toMinute(int hour, int minute) {
        return hour * 60 + minute;
    }
}