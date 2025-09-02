class Solution {

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int num = 0, len = 0;

        // 말한 숫자의 길이가 t에 도달할 때까지 숫자 증가
        while (sb.length() < t) {
            // 현재 숫자를 n진수 문자열로 변환
            for (char c : Integer.toString(num, n).toCharArray()) {
                // 전체 순서 중 튜브의 차례인지 확인
                if (len++ % m == p - 1) {
                    sb.append(Character.toUpperCase(c));
                }
                if (sb.length() == t) break;
            }

            num++;
        }

        return sb.toString();
    }

}