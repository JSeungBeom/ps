import java.util.*;

class Solution {
    
    static int row, col, answer;
    static List<String> orders = new ArrayList<>();
    
    public int solution(String[][] relation) {        
        row = relation.length;
        col = relation[0].length;
        
        boolean[] arr = new boolean[col];
        
        subset(0, col, arr, relation);
        
        
        return orders.size();
    }
    
    static void subset(int n, int k, boolean[] arr, String[][] relation) {
        if(n == k) {
            Set<String> set = new HashSet<>();
            StringBuilder order = new StringBuilder();   
            
            for(int i = 0; i < n; i++) {
                if(arr[i] == true)
                    order.append(i);
            }
            
            for(int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();
                
                for(int j = 0; j < n; j++) {
                    if(arr[j] == true) {
                        sb.append(relation[i][j]);
                    }
                } 
                
                set.add(sb.toString());
            }
        
            if(set.size() == row) {
                for(int i = orders.size() - 1; i >= 0; i--) {
                    String cur = orders.get(i);
                    int cnt = 0;
                    for(int j = 0; j < order.length(); j++) {
                        if(cur.contains(order.substring(j, j + 1))) {
                            cnt++;
                        }
                    }
                    
                    
                    if(cnt == order.length()) orders.remove(i);
                }
                
                orders.add(order.toString());
            }
            
            return;
        }
        
        arr[n] = true;
        subset(n + 1, k, arr, relation);
        
        arr[n] = false;
        subset(n + 1, k, arr, relation);
    }
}

// 1 2 3 4
//   2 3 4
// 1   3 4
// 1 2 3
// 1 2
// 0