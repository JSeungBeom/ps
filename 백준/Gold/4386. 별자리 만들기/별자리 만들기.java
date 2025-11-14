import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static double x, y;
	static List<double[]> stars = new ArrayList<>();
	static List<Edge> edges = new ArrayList<>();
	static int[] p;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
        N = Integer.parseInt(br.readLine());
        
        p = new int[N];
        
        for(int i = 0; i < N; i++) {
        	p[i] = i;
        }
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	x = Double.parseDouble(st.nextToken());
        	y = Double.parseDouble(st.nextToken());
        	
        	stars.add(new double[] {x, y});
        }
        
        for(int i = 1; i < stars.size(); i++) {
        	for(int j = 0; j < i; j++) {
        		double x1 = stars.get(i)[0];
        		double y1 = stars.get(i)[1];
        		double x2 = stars.get(j)[0];
        		double y2 = stars.get(j)[1];
        		
        		double cost = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
        		
        		edges.add(new Edge(i, j, cost));
        		edges.add(new Edge(j, i, cost));
        	}
        }
        
        Collections.sort(edges, (e1, e2) -> e1.cost.compareTo(e2.cost));
        
        double sum = 0;
        int count = 0;
        
        for(int i = 0; i < edges.size(); i++) {
        	int u = edges.get(i).u;
        	int v = edges.get(i).v;
        	double cost = edges.get(i).cost;
        	
        	if(union(u, v)) {
	        	count++;
	        	sum += cost;
        	}
        	
        	if(count == N - 1) break;
        }
        
        System.out.println(sum);
    }
    
    static class Edge {
    	int u;
    	int v;
    	Double cost;
    	
    	Edge(int u, int v, Double cost) {
    		this.u = u;
    		this.v = v;
    		this.cost = cost;
    	}
    }
    
    static int find(int u) {
    	if(u == p[u]) return u;
    	
    	return p[u] = find(p[u]);
    }
    
    static boolean union(int u, int v) {
    	int pu = find(u);
    	int pv = find(v);
    	
    	if(pu < pv) p[pv] = pu;
    	else if(pu > pv) p[pu] = pv;
    	else return false;
    	
    	return true;
    }
}
