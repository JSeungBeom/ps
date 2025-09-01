import java.util.*;

class Solution {

    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = makeMultiset(str1);
        Map<String, Integer> m2 = makeMultiset(str2);

        if (m1.isEmpty() && m2.isEmpty()) return 65536;

        int intersect = 0;
        int union = 0;

        Set<String> keys = new HashSet<>(m1.keySet());
        keys.addAll(m2.keySet());

        for (String k : keys) {
            int c1 = m1.getOrDefault(k, 0);
            int c2 = m2.getOrDefault(k, 0);
            intersect += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }

        return (int) Math.floor((double) intersect * 65536 / union);
    }

    private Map<String, Integer> makeMultiset(String s) {
        Map<String, Integer> map = new HashMap<>();
        String up = s.toUpperCase();

        for (int i = 0; i < up.length() - 1; i++) {
            char a = up.charAt(i);
            char b = up.charAt(i + 1);

            // A-Z만 유효
            if (a < 'A' || a > 'Z' || b < 'A' || b > 'Z') continue;

            String token = "" + a + b;
            map.merge(token, 1, Integer::sum);
        }
        return map;
        }
}
