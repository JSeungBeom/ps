import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
                 HashMap<String,Map<Integer,Integer>> hm = new HashMap<>();
        for(int i =0 ; i< genres.length;i++){
            hm.putIfAbsent(genres[i],new HashMap<>());
            hm.get(genres[i]).put(i,plays[i]);
        }

        int[] answer = hm.entrySet().stream().sorted(Comparator.comparing(vo->vo.getValue()
                .entrySet()
                .stream().mapToInt(v->v.getValue()).sum(),Comparator.reverseOrder()))
                .flatMap(vo->vo.getValue()
                        .entrySet()
                        .stream()
                                .sorted(
                        Comparator.comparing(Map.Entry<Integer,Integer>::getValue, Comparator.reverseOrder()) 
                                .thenComparing(Map.Entry::getKey)
                                )
                        .limit(2)
                ).mapToInt(vo->vo.getKey()).toArray();


        return answer;
    }
}