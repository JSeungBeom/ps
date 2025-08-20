import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    static int[] wanho = new int[2];
    
    public int solution(int[][] scores) {
        int n = scores.length;
        
        wanho[0] = scores[0][0];
        wanho[1] = scores[0][1];

        Arrays.sort(scores, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));

        int maxPeer = -1;
        for (int[] s : scores) {
            int w = s[0], p = s[1];
            if (p < maxPeer) {
                if (w == wanho[0] && p == wanho[1]) return -1;
                continue;
            }
            list.add(new int[]{w, p});
            if (p > maxPeer) maxPeer = p;
        }

        int wanhoSum = wanho[0] + wanho[1];
        int rank = 1;
        for (int[] s : list) {
            if (s[0] + s[1] > wanhoSum) rank++;
        }
        return rank;
    }
}
