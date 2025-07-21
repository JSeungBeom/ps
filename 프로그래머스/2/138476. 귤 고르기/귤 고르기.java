import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int size : tangerine) {
            sizeMap.merge(size, 1, Integer::sum); // 귤 크기별 개수 집계
        }

        List<Integer> sizeCounts = new ArrayList<>(sizeMap.values());
        sizeCounts.sort(Comparator.reverseOrder()); // 개수 기준 내림차순 정렬

        for (int count : sizeCounts) {
            k -= count;
            answer++;              // 현재 종류 선택
            if (k <= 0) break;     // k개를 모두 고르면 종료
        }

        return answer;
    }
}