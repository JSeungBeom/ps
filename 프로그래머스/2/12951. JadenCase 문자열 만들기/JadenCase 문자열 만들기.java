class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isStart = true; 

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                isStart = true;
            } else {
                if (isStart) {
                    answer.append(Character.toUpperCase(c));
                    isStart = false;
                } else {
                    answer.append(Character.toLowerCase(c));
                }
            }
        }

        return answer.toString();
    }
}
