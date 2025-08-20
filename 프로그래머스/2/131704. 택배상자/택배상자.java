import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> sub = new ArrayDeque<>(); // 보조 컨베이어(스택)
        int n = order.length;
        int idx = 0;

        for (int box = 1; box <= n; box++) {
            // 보조에서 실을 수 있으면 최대한 싣기
            while (!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop(); idx++;
            }

            // 지금 온 박스가 바로 실을 차례면 싣기
            if (box == order[idx]) {
                idx++;
            } else {
                // 아니면 보조로 보내기
                sub.push(box);
            }
        }

        // 남은 보조에서 더 실을 수 있으면 계속 싣기
        while (!sub.isEmpty() && sub.peek() == order[idx]) {
            sub.pop(); idx++;
        }

        return idx; // 실은 박스 수
    }
}
