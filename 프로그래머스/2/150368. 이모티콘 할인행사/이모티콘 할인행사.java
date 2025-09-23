import java.util.*;

class Solution {
    
    static int[] arr;
    static int[] sales = new int[] {10, 20, 30, 40};
    static PriorityQueue<int[]> pq 
        = new PriorityQueue<>((o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));
    
    public int[] solution(int[][] users, int[] emoticons) {        
        arr = new int[emoticons.length];
        
        perm(0, emoticons.length, users, emoticons);

        return pq.poll();
    }
    
    static void perm(int n, int k, int[][] users, int[] emoticons) {
        if(n == k) {
            solve(users, emoticons);
            
            return;
        }
        
        for(int i = 0; i < sales.length; i++) {
            arr[n] = sales[i];
            perm(n + 1, k, users, emoticons);
        }
    }
    
    static void solve(int[][] users, int[] emoticons) {
        int plus = 0, cost = 0;
        for(int i = 0; i < users.length; i++) {
            int percent = users[i][0];
            int limit = users[i][1];
            int sum = 0;
            
            for(int j = 0; j < emoticons.length; j++) {
                if(arr[j] >= percent) {
                    sum += (emoticons[j] * (100 - arr[j]) / 100);        
                }
            }
            
            if(sum >= limit) {
                plus++;
            }
            else{
                cost += sum;
            }
            
            
        }
                        
        pq.add(new int[] {plus, cost});
    }
}