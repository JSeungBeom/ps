import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int M, S;
	static int[] dx = new int[] { 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = new int[] { -1, -1, 0, 1, 1, 1, 0, -1};
	
	static int[] ddx = new int[] { -1, 0, 1, 0};
	static int[] ddy = new int[] { 0, -1, 0, 1};
	
	static FishList[][] fishes = new FishList[4][4];
	static int[][] smells = new int[4][4];
	static Shark shark;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		fishes[i][j] = new FishList();
        	}
        }
         
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	Fish fish = new Fish(x - 1, y - 1, d - 1);
        	
        	fishes[x - 1][y - 1].addFish(fish);
        }
        
        st = new StringTokenizer(br.readLine());
        	
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        shark = new Shark(x - 1, y - 1);
        
        for(int i = 0; i < S; i++) {
        	// 복제 마련
        	FishList[][] copyFishes = copyFish();
        	
        	// 물고기 이동
        	moveFish();
        	
        	// 상어 이동 & 물고기 냄새 남기기
        	moveShark();
        	
        	// 냄새 삭제
        	removeSmell();
        	
        	// 복제
        	addFish(copyFishes);
            
        }
        

        
        System.out.println(getFishCount());
    }
    
    static int getFishCount() {
    	int cnt = 0;
    	
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			cnt += fishes[i][j].fishList.size();
    		}
    	}
    	
    	return cnt;
    }
    
    static void addFish(FishList[][] copyFishes) {
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			fishes[i][j].addFishes(copyFishes[i][j].fishList);
    		}
    	}
    }
    
    static void removeSmell() {
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			if(smells[i][j] == 0) continue;
    			
    			smells[i][j]--;
    		}
    	}
    }
    
    static void moveShark() {
    	int max = 0;
    	
		for(int i = 0; i < 64; i++) {
			int x = shark.x;
	    	int y = shark.y;
			int div = i;
			int cnt = 0;
			boolean isMovable = true;
	    	boolean[][] vis = new boolean[4][4];
	    	List<Integer> order = new ArrayList<>();
	    	
	    	for(int j = 0; j < 3; j++) {
	    		int dir = div % 4;
	    		div /= 4;
	    		
	    		order.add(dir);
	    	}
	    	
	    	Collections.reverse(order);
	    	
			for(int j = 0; j < 3; j++) {
				int dir = order.get(j);
				x += ddx[dir];
				y += ddy[dir];
				

				if(OOB(x, y)) {
					isMovable = false;
					break;
				}
				
				if(vis[x][y]) continue;
				
				cnt += fishes[x][y].fishList.size();
				vis[x][y] = true;
			}
			
			if(!isMovable) continue;
			
			max = Math.max(max, cnt);
		}
		
		for(int i = 0; i < 64; i++) {
			int x = shark.x;
	    	int y = shark.y;
			int div = i;
			int cnt = 0;
			boolean isMovable = true;
	    	boolean[][] vis = new boolean[4][4];
			List<int[]> pos = new ArrayList<>();
	    	List<Integer> order = new ArrayList<>();
	    	
	    	for(int j = 0; j < 3; j++) {
	    		int dir = div % 4;
	    		div /= 4;
	    		
	    		order.add(dir);
	    	}
	    	
	    	Collections.reverse(order);
	    	
			for(int j = 0; j < 3; j++) {
				int dir = order.get(j);		
				
				x += ddx[dir];
				y += ddy[dir];
				
				
				pos.add(new int[] {x, y});
				
				if(OOB(x, y)) {
					isMovable = false;
					break;
				}
				
				if(vis[x][y]) continue;
	
				cnt += fishes[x][y].fishList.size();
				vis[x][y] = true;
			}
			
			if(!isMovable) continue;
			
			if(max == cnt) {
				for(int[] cur : pos) {
					List<Fish> fishList = fishes[cur[0]][cur[1]].fishList;
					

					if(fishList.isEmpty()) continue;
					smells[cur[0]][cur[1]] = 3;
					fishList.clear();
					
 				}
				
				shark.x = pos.get(2)[0];
				shark.y = pos.get(2)[1];
				
				break;
			}
		}
    }
    
    static void moveFish() {
    	FishList[][] newFishes = new FishList[4][4];
    	
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			newFishes[i][j] = new FishList();
    		}
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			List<Fish> fishList = fishes[i][j].fishList;
    			
    			if(fishList.isEmpty()) continue;
    			
    			for(Fish fish : fishList) {
    				boolean moved = false;
    				
    				for(int k = 0; k < 8; k++) {
	    				int x = fish.x;
	    				int y = fish.y;
	    				int dir = fish.dir - k;
	    				
	    				if(dir < 0) dir += 8;
	    				
	    				int nx = x + dx[dir];
	    				int ny = y + dy[dir];
	    				
	    				if(OOB(nx, ny) || (shark.x == nx && shark.y == ny) || smells[nx][ny] > 0) continue;
	    					
	    				newFishes[nx][ny].addFish(new Fish(nx, ny, dir));
	    				moved = true;
	    				break;
    				}

        			if(!moved) {
        				newFishes[fish.x][fish.y].addFish(new Fish(fish.x, fish.y, fish.dir));
        			}
    			}
    			
    		}
    	}
    	
    	fishes = newFishes;
    }
    
    static boolean OOB(int x, int y) {
    	return x < 0 || x >= 4 || y < 0 || y >= 4;
    }
    
    static FishList[][] copyFish() {
    	FishList[][] tmpFishes = new FishList[4][4];
    	
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		tmpFishes[i][j] = new FishList();
        	}
        }
    	
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			List<Fish> fishList = fishes[i][j].fishList;
    			
    			if(fishList.isEmpty()) continue;
    			
    			for(Fish fish : fishList) {
    				tmpFishes[i][j].addFish(new Fish(fish.x, fish.y, fish.dir));
    			}
    		}
    	}
    	
    	return tmpFishes;
    }
    
    static class Shark {
    	int x;
    	int y;
    	
    	Shark(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
    static class Fish {
    	int x;
    	int y;
    	int dir;
    	
    	Fish(int x, int y, int dir) {
    		this.x = x;
    		this.y = y;
    		this.dir = dir;
    	}
    }
    
    static class FishList {
    	List<Fish> fishList = new ArrayList<>();
    	
    	void addFish(Fish fish) {
    		fishList.add(fish);
    	}
    	
    	void addFishes(List<Fish> fishes) {
    		fishList.addAll(fishes);
    	}
    	
    	void removeFish(Fish fish) {
    		fishList.remove(fish);
    	}
    }
    
}