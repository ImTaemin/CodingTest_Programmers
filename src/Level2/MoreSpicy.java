package Level2;

import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class MoreSpicy
{
    public static void main(String[] args)
    {
        solution(new int[]{1,2,3,9,10,12}, 7);
    }

    public static int solution(int[] scoville, int K)
    {
        // scoville : 스코빌 지수를 담은 배열
        // K : 원하는 스코빌 지수
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수 반환
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번쨰로 맵지 않은 음식의 스코빌 지수*2)

        // PriorityQueue는 자동으로 오름차순이 된다. -> 제일 작은 값과 하나 더 큰값 비교

        int answer = 0;

        // 최소힙
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i:scoville)
        {
            heap.add(i);
        }

        while (heap.peek() < K)
        {
            int v1 = heap.poll();
            int v2 = heap.poll();

            heap.add(v1 + (v2*2));
            answer++;

            if(heap.peek() >= K)
            {
                break;
            }

            // 마지막 체크
            if(heap.peek() < K && heap.size() == 1)
            {
                answer = -1;
                break;
            }

        }

        return answer;
    }
}
