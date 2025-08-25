import java.util.*;

class Solution {
    
    HashMap<String, Integer> cache = new HashMap<>();
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            if(cache.containsKey(city)) {
                for(String key : cache.keySet()) {
                    cache.put(key, cache.get(key) + 1);
                }
                
                cache.put(city, 1);
                answer += 1;
            }
            else {
                if(cache.size() == cacheSize) { 
                    String removed = "";

                    int max = 0;

                    for(String key : cache.keySet()) {
                        if(max < cache.get(key)) {
                            max = cache.get(key);
                            removed = key;
                        }    
                    }

                    cache.remove(removed);
                }
                
                for(String key : cache.keySet()) {
                    cache.put(key, cache.get(key) + 1);
                }
                
                
                cache.put(city, 1);
                
                answer += 5;
            }
            
            
        }
        
        return answer;
    }
}