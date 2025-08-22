import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, L, H;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> answers = new ArrayList<>();
	static int answer;
	static int maxH, maxIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {L, H});
		}
		
		Collections.sort(list, (o1, o2) -> (o1[0] - o2[0]));
		
		for(int i = 0; i < N; i++) {
			int h = list.get(i)[1];
			
			if(maxH < h) {
				maxH = h;
				maxIdx = i;
			}
		}
		
		int cur = 0;
		
		for(int i = 0; i <= maxIdx; i++) {
			if(list.get(i)[1] > cur) {
				answers.add(new int[] {list.get(i)[0], list.get(i)[1]});
				cur = list.get(i)[1];
			}
		}
		
		cur = 0;
		
		for(int i = N - 1; i > maxIdx; i--) {
			if(list.get(i)[1] > cur) {
				answers.add(new int[] {list.get(i)[0], list.get(i)[1]});
				cur = list.get(i)[1];
			}
		}
		
		Collections.sort(answers, (o1, o2) -> (o1[0] - o2[0]));
		
		for(int i = 0; i < answers.size(); i++) {
			int h = answers.get(i)[1];
			
			if(maxH == h) {
				maxIdx = i;
			}
		}

		for(int i = 0; i < maxIdx; i++) {
			answer += (answers.get(i)[1] * (answers.get(i + 1)[0] - answers.get(i)[0]));
		}
		
		answer += maxH;
		
		for(int i = answers.size() - 1; i > maxIdx; i--) {
			answer += (answers.get(i)[1] * (answers.get(i)[0] - answers.get(i - 1)[0]));
		}
		
		System.out.println(answer);
	}
	
}