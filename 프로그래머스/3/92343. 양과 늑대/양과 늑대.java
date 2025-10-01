import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] info;
    int n;
    int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.n = info.length;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) graph[e[0]].add(e[1]); // 부모->자식

        // 시작: 노드 0 방문, 후보에 0의 자식들 추가
        int startMask = 1 << 0;
        List<Integer> startCand = new ArrayList<>(graph[0]); // 0의 자식들
        dfs(startMask, 1, 0, startCand); // info[0] == 0이 보장(양)

        return maxSheep;
    }

    void dfs(int visitedMask, int sheep, int wolf, List<Integer> candidates) {
        maxSheep = Math.max(maxSheep, sheep);

        // 후보에서 하나 골라 진행
        for (int i = 0; i < candidates.size(); i++) {
            int next = candidates.get(i);
            if ((visitedMask & (1 << next)) != 0) continue; // 이미 방문

            int ns = sheep;
            int nw = wolf;
            if (info[next] == 0) ns++;
            else {
                nw++;
                if (nw >= ns) continue; // 가지치기: 늑대 수가 양 이상이면 불가
            }

            int nMask = visitedMask | (1 << next);

            // 다음 후보 목록 구성: 현재 후보에서 next를 제거하고, next의 자식들을 추가
            List<Integer> nextCand = new ArrayList<>();
            // 기존 후보 중 next 제외
            for (int j = 0; j < candidates.size(); j++) {
                int c = candidates.get(j);
                if (c != next) nextCand.add(c);
            }
            // next의 자식 추가
            nextCand.addAll(graph[next]);

            dfs(nMask, ns, nw, nextCand);
        }
    }
}
