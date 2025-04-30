import java.util.*;

class Solution {
    
    Set<Set<String>> resultSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        backtrack(new HashSet<>(), user_id, banned_id, 0);
        return resultSet.size();
    }

    void backtrack(Set<String> currentSet, String[] user_id, String[] banned_id, int index) {
        if (index == banned_id.length) {
            resultSet.add(new HashSet<>(currentSet)); // 조합 중복 제거
            return;
        }

        for (String user : user_id) {
            if (currentSet.contains(user)) continue;
            if (isMatch(user, banned_id[index])) {
                currentSet.add(user);
                backtrack(currentSet, user_id, banned_id, index + 1);
                currentSet.remove(user);
            }
        }
    }

    boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}
