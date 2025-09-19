import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;

        int answer = n;

        for (int slice = 1; slice <= n / 2; slice++) {
            int len = 0;

            String prev = s.substring(0, slice);
            int run = 1;

            int i = slice;
            while (i < n) {
                int end = Math.min(n, i + slice);
                String cur = s.substring(i, end);

                if (cur.length() < slice) {
                    len += slice + digits(run);
                    len += cur.length();
                    run = 0;
                    break;
                }

                if (cur.equals(prev)) {
                    run++;
                } else {
                    len += slice + digits(run);
                    prev = cur;
                    run = 1;
                }
                i += slice;
            }

            if (run > 0) {
                len += slice + digits(run);
            }

            answer = Math.min(answer, len);
        }

        return answer;
    }

    private int digits(int x) {
        return (x > 1) ? Integer.toString(x).length() : 0;
    }
}
