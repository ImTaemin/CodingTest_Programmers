package Level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java
public class Printer
{
    public static void main(String[] args)
    {
        solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    // PriorityQueue 사용
    public static int solution(int[] priorities, int location)
    {
        // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼낸다.
        // 2. 나머지 에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 배치
        // 3. 그렇지 않으면 J 인쇄.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++)
        {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty())
        {
            for (int i = 0; i < priorities.length; i++)
            {
                if (priorities[i] == pq.peek())
                {
                    if (i == location)
                    {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }

    // 일반 큐 사용
    public static int solution1(int[] priorities, int location)
    {
        int answer = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        for (int i : priorities)
        {
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!que.isEmpty())
        {
            Integer i = que.poll();
            if (i == priorities[size - answer])
            {
                answer++;
                location--;
                if (location < 0)
                    break;
            }
            else
            {
                que.add(i);
                location--;
                if (location < 0)
                    location = que.size() - 1;
            }
        }

        return answer;
    }
}
