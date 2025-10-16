import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, x, y, answer;
	static Deque<Integer> stack = new ArrayDeque<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        stack.push(0);
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());

    		while(stack.peek() > y) {
    			stack.pop();
    			answer++;
    		}
    		
    		if(y > stack.peek()) {
    			stack.push(y);
    		}    		
        }
        
        while(!stack.isEmpty()) {
        	int cur = stack.pop();
        	
        	if(cur != 0) answer++;
        }
     
        
        System.out.println(answer);
   
    }
}

// 같은 Y 좌표에서 X 좌표가 이어져 있는지 판단
// 높은 Y -> 낮은 Y , 중간 값들은 끊어짐
//..........................
//..XX.XX.........XXX.......
//.XXX.XX.......XXXXXXX.....
//XXXXXXXXXX....XXXXXXXXXXXX

