class Solution {
    public long solution(int[] sequence) {
        long ans = Long.MIN_VALUE;

        long cur1 = 0; 
        long cur2 = 0;

        for (int i = 0; i < sequence.length; i++) {
            long a = sequence[i];

            long p1 = (i % 2 == 0) ? +a : -a;
            long p2 = -p1;

            cur1 = Math.max(p1, cur1 + p1);
            cur2 = Math.max(p2, cur2 + p2);

            ans = Math.max(ans, Math.max(cur1, cur2));
        }

        return ans;
    }
}
