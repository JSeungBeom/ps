import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, k;
	static int time;
	static Shark[][] sharks;
	static Smell[][] smells;
	static List<Shark> sharkList = new ArrayList<>();
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        sharks = new Shark[N][N];
        smells = new Smell[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < N; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		
        		Shark shark = num == 0 ? null : new Shark(i, j, num);
        		
        		if(shark == null) continue;
        		
        		sharks[i][j] = shark;
        		sharkList.add(shark);
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        
        Collections.sort(sharkList, (s1, s2) -> (s1.num - s2.num));
        
        for(int i = 0; i < M; i++) {
        	int curDir = Integer.parseInt(st.nextToken());	
        	sharkList.get(i).dir = curDir - 1;
        }
        
        for(int i = 0; i < M; i++) {
        	for(int j = 0; j < 4; j++) {
        		st = new StringTokenizer(br.readLine());
        		
        		for(int k = 0; k < 4; k++) {
        			int curPriority = Integer.parseInt(st.nextToken());
        			sharkList.get(i).priority[j][k] = curPriority - 1;
        		}
        	}
        }
        
        Collections.reverse(sharkList);

        while(!checkSharkList() && time <= 1000) {
        	time++;
        	spreadSmell();
        	moveShark();
        	decreaseSmell();
        	
//        	for(int i = 0; i < N; i++) {
//        		for(int j = 0; j < N; j++) {
//        			System.out.print(sharks[i][j] == null ? 0 + " " : sharks[i][j].num + " ");
//        		}
//        		System.out.println();
//        	}
//        	System.out.println();
//        	
//        	for(int i = 0; i < N; i++) {
//        		for(int j = 0; j < N; j++) {
//        			System.out.print(smells[i][j] == null ? 0 + " " : smells[i][j].num + "," + smells[i][j].t + " ");
//        		}
//        		System.out.println();
//        	}
//        	System.out.println();
        }
        
        System.out.println(time > 1000 ? -1 : time);
    }
    
    static boolean checkSharkList() {
    	return sharkList.size() == 1;
    }
    
    static void decreaseSmell() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(smells[i][j] == null) continue;
    			
    			if(--smells[i][j].t == 0) {
    				smells[i][j] = null;
    			}
    		}
    	}
    }
    
    static void spreadSmell() {
    	for(Shark shark : sharkList) {
    		int x = shark.x;
    		int y = shark.y;
    		int num = shark.num;
    		
    		smells[x][y] = new Smell(num, k);
    	}
    }
    
    static void moveShark() {
    	for(int idx = sharkList.size() - 1; idx >= 0; idx--) {
    		Shark shark = sharkList.get(idx);
    		int x = shark.x;
    		int y = shark.y;
    		int dir = shark.dir;
    		int num = shark.num;
    		int[] priority = shark.priority[dir];
//    		System.out.println(num + " " + dir);
    		boolean isMoved = false;
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = x + dx[priority[i]];
    			int ny = y + dy[priority[i]];
    			
    			if(OOB(nx, ny)) continue;
    			if(smells[nx][ny] == null) {
    				if(sharks[nx][ny] != null) {
    					sharkList.remove(shark);
    					sharks[x][y] = null;
    					isMoved = true;
    					break;
    				}
    				
    				sharks[nx][ny] = shark;
    				sharks[x][y] = null;
    				
    				shark.x = nx;
    				shark.y = ny;
    				shark.dir = priority[i];
    				isMoved = true;
    				
    				break;
    			}
    		}
    		
    		if(isMoved) continue;
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = x + dx[priority[i]];
    			int ny = y + dy[priority[i]];
    			
    			if(OOB(nx, ny)) continue;
    			if(smells[nx][ny].num == num) {
    				if(sharks[nx][ny] != null) {
    					sharkList.remove(shark);
    					sharks[x][y] = null;
    					break;
    				}
    				sharks[nx][ny] = shark;
    				sharks[x][y] = null;
    				
    				shark.x = nx;
    				shark.y = ny;
    				shark.dir = priority[i];
    				
    				break;
    			}
    		}
    	}
    }
    
    static boolean OOB(int x, int y) {
    	return x < 0 || x >= N || y < 0 || y >= N;
    }
    
    static class Shark {
    	int x;
    	int y;
    	int num;
    	int dir;
    	int[][] priority = new int[4][4];
    	
    	Shark(int x, int y, int num) {
    		this.x = x;
    		this.y = y;
    		this.num = num;
    	}
    }
    
    static class Smell {
    	int num;
    	int t;
    	
    	Smell(int num, int t) {
    		this.num = num;
    		this.t = t;
    	}
    }
}
