package Level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12982
public class Budget
{

    public static void main(String[] args)
    {
        solution(new int[]{1, 3, 2, 5, 4}, 9);
    }

    public static int solution(int[] d, int budget)
    {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++)
        {
            if (d[i] <= budget)
            {
                budget -= d[i];
                answer++;
            }
            else
            {
                break;
            }
        }

        return answer;
    }
}
