package Level1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java
public class MockTest
{
    public static void main(String[] args)
    {
        int[] res = solution(new int[]{1, 2, 2, 3, 2, 5, 1, 5, 4, 5, 1, 2, 4, 3, 3, 5, 1, 5, 1, 3});
        System.out.println(res[0]);
    }

    public static int[] solution(int[] answers)
    {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] hits = {0,0,0};

        // 맞춘 사람은 점수+1
        for (int i = 0; i < answers.length; i++)
        {
            if (a[i % a.length] == answers[i]) hits[0]++;
            if (b[i % b.length] == answers[i]) hits[1]++;
            if (c[i % c.length] == answers[i]) hits[2]++;
        }

        // 12,10,15
        int max = Math.max(hits[0], Math.max(hits[1], hits[2]));

        List<Integer> list = new ArrayList<>();
        if(max == hits[0]) list.add(1);
        if(max == hits[1]) list.add(2);
        if(max == hits[2]) list.add(3);

        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
