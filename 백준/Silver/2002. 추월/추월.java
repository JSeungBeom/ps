import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static int N;
	static String[] exit;
	static Map<String, Integer> carOrder = new HashMap<>();
	static int answer;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	N = Integer.parseInt(br.readLine());
    	
    	exit = new String[N];
    	
    	for(int i = 0; i < N; i++) {
    		String car = br.readLine();
    		
    		carOrder.put(car, i);
    	}

    	
    	for(int i = 0; i < N; i++) {
    		String car = br.readLine();
    		
    		exit[i] = car;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = i + 1; j < N; j++) {
    			if(carOrder.get(exit[j]) < carOrder.get(exit[i])) {
    				answer++; break;
    			}
    		}
    	}
    	
    	
    	System.out.println(answer);
    }

}

