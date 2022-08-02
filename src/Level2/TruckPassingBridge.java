package Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java
public class TruckPassingBridge
{
    public static void main(String[] args)
    {
        solution(2, 10, new int[]{7, 4, 5, 6});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights)
    {

        // 일차선 다리를 건너려면 최소 몇 초 걸리는지.

        // bridge_length : 최대로 트럭이 올라갈 수 있는 개수
        // weight : 무게 제한 ( 다리에 완전히 오르지 않은 트럭 무게 무시)
        // truck_weights : 트럭들 (무게로 표시)

        int currentWeight = 0;
        int time = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++)
        {
            int truck = truck_weights[i];
            while (true)
            {
                // 다리에 아무것도 없는 경우
                if (queue.isEmpty())
                {
                    queue.add(truck);
                    currentWeight += truck;

                    time++;
                    break;
                }
                else if(queue.size() == bridge_length)
                {
                    // 다리에 길이만큼 트럭이 차면
                    currentWeight -= queue.poll();
                }
                else
                {
                    // 건널 수 있는 상태
                    if (currentWeight + truck <= weight)
                    {
                        queue.add(truck);
                        currentWeight += truck;

                        time++;
                        break;
                    }
                    else
                    {
                        // 이미 다리에 있는 트럭 지나가게
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        // 마지막 트럭도 다리 길이만큼 지나가야해서 +다리 길이
        return time + bridge_length;
    }

    // 다른 사람의 풀이(객체 이용)
    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static int solution1(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
