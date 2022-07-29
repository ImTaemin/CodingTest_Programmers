package Level1;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// https://school.programmers.co.kr/learn/courses/30/lessons/77484
public class Lotto
{
    public static void main(String[] args)
    {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19}; //1~45

//        solution(lottos, win_nums);
        solutionStream(lottos, win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums)
    {

        int dispatch = 0, zero = 0, high = 0, low = 0;

        for (int l : lottos)
        {
            for (int w : win_nums)
            {
                if (l == w)
                {
                    dispatch++;
                    break;
                }
                else if (l == 0)
                {
                    zero++;
                    break;
                }
            }
        }

        low = dispatch;
        high = dispatch + zero;

        int[] answer = {Math.min(7 - high, 6), Math.min(7 - low, 6)};
        Stream<Integer> stream = Arrays.stream(answer).boxed();
        stream.forEach(System.out::print);

        return answer;
    }

    public static int[] solutionStream(int[] lottos, int[] winNums)
    {
        Long a = (lottos.length + 1) - Arrays.stream(lottos)
                .filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count();
        Long b = (lottos.length + 1) - Arrays.stream(lottos)
                .filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count();
        return LongStream.of(a, b)
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }

    public static int[] solution3(int[] lottos, int[] win_nums)
    {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for (int lotto : lottos)
        {
            if (lotto == 0)
            {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }

        int sameCount = 0;
        for (int winNum : win_nums)
        {
            if (map.containsKey(winNum))
            {
                sameCount++;
            }
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;

        if (maxRank > 6)
        {
            maxRank = 6;
        }
        if (minRank > 6)
        {
            minRank = 6;
        }

        return new int[]{maxRank, minRank};
    }
}
