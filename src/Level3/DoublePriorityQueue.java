package Level3;

import java.util.Collections;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
public class DoublePriorityQueue
{
    public static void main(String[] args)
    {
        solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
    }

    public static int[] solution(String[] operations)
    {
        int[] answer = new int[2];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++)
        {
            char operation = operations[i].charAt(0);
            int num = Integer.parseInt(operations[i].split(" ")[1]);

            if (minHeap.size() == 0 && operation == 'D')
                continue;

            if (operation == 'I')
            {
                maxHeap.add(num);
                minHeap.add(num);
                continue;
            }
            // 최소값 삭제
            if (operation == 'D' && num == -1)
            {
                int tmp = minHeap.poll();
                maxHeap.remove(tmp);
                continue;
            }
            // 최대값 삭제
            if (operation == 'D' && num == 1)
            {
                int tmp = maxHeap.poll();
                minHeap.remove(tmp);
                continue;
            }
        }

        if (minHeap.size() > 0)
        {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}
