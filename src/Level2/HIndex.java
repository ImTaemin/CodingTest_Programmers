package Level2;

import java.util.Arrays;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java
public class HIndex
{
    public static void main(String[] args)
    {
        System.out.println(solution(new int[]{0, 0, 0, 0, 0}));
    }

    // 내가 한 풀이
    public static int solution(int[] citations)
    {
        // H-Index 구하는 법
        /*
         발표한 논문 n편 중,
         h번 이상 인용된 논문이 h편 이상이고
         나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 H-Index
        */

        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.reverseOrder());

        int i = 0;
        while (i < arr.length)
        {
            if (i >= arr[i])
            {
                return i;
            }
            i++;
        }
        return i;
    }

    // 다른 사람이 한 풀이
    public static int solution1(int[] citations)
    {
        Arrays.sort(citations);

        // 원소 값은 점점 감소하고, 원소 값 이상인 것의 개수는 점점 감소하므로
        // 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점이 답.
        int max = 0;
        for (int i = citations.length - 1; i > -1; i--)
        {
            int min = (int) Math.min(citations[i], citations.length - i);
            if (max < min)
            {
                max = min;
            }
        }

        return max;
    }
}
