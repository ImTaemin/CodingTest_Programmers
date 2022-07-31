package Level1;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class AddPick2
{
    public static void main(String[] args)
    {
        solution(new int[]{2, 1, 3, 4, 1});
    }

    public static int[] solution(int[] numbers)
    {
        Set<Integer> resultSet = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                resultSet.add(numbers[i] + numbers[j]);

        int[] answer = new int[resultSet.size()];
        Iterator<Integer> iter = resultSet.iterator();
        for (int i = 0; i < answer.length; i++)
            answer[i] = iter.next();

        return answer;
    }

    // 다른 사람의 풀이 가독성은 좋지만 속도면에선 떨어짐.
    public int[] solution1(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
