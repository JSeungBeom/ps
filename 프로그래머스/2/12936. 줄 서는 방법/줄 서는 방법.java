import java.util.*;

class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;

        k--; // 0-based 인덱스로 변환
        for (int i = 0; i < n; i++) {
            fact /= (n - i);                // 현재 자리에서의 그룹 크기
            int index = (int) (k / fact);   // 현재 자리에서 선택할 숫자 인덱스

            answer[i] = list.get(index);    // 해당 숫자 선택
            list.remove(index);             // 사용한 숫자 제거
            k %= fact;                      // 남은 k 업데이트
        }

        return answer;
    }

}