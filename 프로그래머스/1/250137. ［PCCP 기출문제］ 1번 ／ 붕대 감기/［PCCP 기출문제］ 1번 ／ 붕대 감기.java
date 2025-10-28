class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        
        for(int i = 0; i < attacks.length; i++) {
            if(i > 0)
                curHealth = heal(bandage, attacks[i][0] - attacks[i - 1][0] - 1, curHealth, health);
            else
                curHealth = heal(bandage, attacks[i][0], curHealth, health);
            
            System.out.println(i + " " + curHealth);
            
            curHealth -= attacks[i][1];
            
            System.out.println(i + " " + curHealth);

            
            if(curHealth <= 0) return -1;
        }
        
        return curHealth;
    }
    
    static int heal(int[] bandage, int sec, int cur, int health) {
        if(cur == health) return cur;
        
        int curHealth = cur;
        
        for(int i = 1; i <= sec; i++) {
            if(i % bandage[0] == 0) {
                if(curHealth + bandage[1] + bandage[2] <= health)
                    curHealth += (bandage[1] + bandage[2]);
                else {
                    curHealth = health;
                    return curHealth;
                }
            } else {
                if(curHealth + bandage[1] <= health)
                    curHealth += bandage[1];
                else {
                    curHealth = health;
                    return curHealth;
                }
            }    
        }
        
        return curHealth;
    }
}