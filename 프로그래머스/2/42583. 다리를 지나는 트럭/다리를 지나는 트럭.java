import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int bridgeWeight = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                // 1. 다리가 비어 있을 경우
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    bridgeWeight += truck;
                    time++;
                    break;
                }
                // 2. 다리가 꽉 찬 경우
                else if (bridge.size() == bridge_length) {
                    bridgeWeight -= bridge.poll(); // 트럭이 다리를 빠져나감
                }
                // 3. 현재 트럭을 올릴 수 있을 경우
                else {
                    if (bridgeWeight + truck <= weight) {
                        bridge.add(truck);
                        bridgeWeight += truck;
                        time++;
                        break;
                    } else {
                        // 트럭을 못 올리면 0을 넣어 한 칸 시간 흐름 시뮬레이션
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        
        // 마지막 트럭이 다리에서 빠져나가는 시간 추가
        return time + bridge_length;
    }
}
