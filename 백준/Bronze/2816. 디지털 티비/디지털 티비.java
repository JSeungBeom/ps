import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static String[] channels;
	static List<Integer> answer = new ArrayList<>();
	static int N;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		channels = new String[N];

		for(int i = 0; i < N; i++) {
			channels[i] = br.readLine();
		}
		
		boolean isFront = false;
		boolean isBack = false;
		
		for(int i = 0; i < N; i++) {
			if(channels[i].equals("KBS1")) {
				isFront = true; break;
			}
			else if(channels[i].equals("KBS2")) {
				isBack = true; break;
			}
			
		}
		
		int size = 0;
		
		for(int i = 0; i < N; i++) {
			if(channels[i].equals("KBS1")) break;
			
			answer.add(1); size++;
		}
		
		for(int i = 0; i < size; i++) {
			answer.add(4);
		}
		
		if(isFront) {
			size = 0;
			
			for(int i = 0; i < N; i++) {
				if(channels[i].equals("KBS2")) break;
				
				answer.add(1); size++;
			}
			
			for(int i = 1; i < size; i++) {
				answer.add(4);
			}
		} 
		
		if(isBack) {
			size = 0;
			
			for(int i = 0; i < N; i++) {
				answer.add(1); size++;
				
				if(channels[i].equals("KBS2")) break;
			}
			
			for(int i = 1; i < size; i++) {
				answer.add(4);
			}
		}
		
		for(int e : answer) System.out.print(e);
	}
	

}