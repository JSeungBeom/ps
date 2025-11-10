import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int sizeA, sizeB;
	static Set<Integer> A = new HashSet<>();
	static Set<Integer> B = new HashSet<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sizeA = Integer.parseInt(st.nextToken());
		sizeB = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < sizeA; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < sizeB; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int elem : A) {
			if(B.contains(elem)) {
				sizeA--;
			}
		}
		
		for(int elem : B) {
			if(A.contains(elem)) {
				sizeB--;
			}
		}
		
		System.out.println(sizeA + sizeB);
	}

}
