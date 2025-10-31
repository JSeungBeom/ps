import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        
        int max = n / 2;
        
        Arrays.sort(nums);
        
        int cnt = 1;
        int prev = nums[0];
        
        for(int i = 1; i < n; i++) {
            if(prev != nums[i]) {
                cnt++;
                prev = nums[i];
            }    
        }
        
        return max < cnt ? max : cnt;
    }
}