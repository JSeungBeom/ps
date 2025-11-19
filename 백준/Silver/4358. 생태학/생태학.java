import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

	static TreeMap<String, Integer> map = new TreeMap<>();
	static String tree;
	static int total;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	while((tree = br.readLine()) != null) {

    		total++;
    		map.put(tree, map.getOrDefault(tree, 0) + 1);
    		
    	}
    	
    	for(String key : map.keySet()) {
    		System.out.println(key + " " + String.format("%.4f", (double)map.get(key) / total * 100));
    	}
    }

}

