import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	static int N;
	static int[] arr;
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	 
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	for(int i = 0; i < N; i++) {
    		if(maxHeap.size() > minHeap.size()) minHeap.offer(arr[i]);
    		else maxHeap.offer(arr[i]);
    		
    		if(maxHeap.isEmpty() || minHeap.isEmpty()) {
    			System.out.println(maxHeap.peek());
    			continue;
    		}
    		
    		if(maxHeap.peek() > minHeap.peek()) {
    			int tmp = maxHeap.poll();
    			maxHeap.offer(minHeap.poll());
    			minHeap.offer(tmp);
    		}
    		
    		System.out.println(maxHeap.peek());
    	}
    }
	
}