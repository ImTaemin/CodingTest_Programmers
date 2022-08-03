package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class LargestNum
{
    public static void main(String[] args)
    {
        solution(new int[]{6, 10, 2});
    }

    public static String solution(int[] numbers)
    {
        StringBuilder answer = new StringBuilder();

        // 이 방법도 있는데 더 느림
//        String[] arr = Arrays.stream(numbers).boxed().map(String::valueOf).toArray(String[]::new);
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (v1, v2) -> (v2 + v1).compareTo(v1 + v2));

        if (arr[0].equals("0"))
        {
            return "0";
        }

        for (String s : arr)
        {
            answer.append(s);
        }
        return answer.toString();
    }

    // 다른 사람이 한 풀이
    public static String solution2(int[] numbers)
    {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
        {
            list.add(numbers[i]);
        }

        //이 부분 해석
        /*
        list에서 순서대로 2개의 요소를 추출합니다. 이를 각각 a와 b로 정의하고 String 자료형으로 만들어 as와 bs를 만듭니다.
        그리고 return문에 보면 as + bs와 bs + as를 수행합니다.
        여기서 주목해야하는 부분은 자리를 교체했다는 점입니다(= bs + as 케이스). 만약 as = 10, bs = 20인 경우, 연산의 결과는 1020과 2010으로 나옵니다.
        이 결과 값을 가지고 Integer.compare()를 수행합니다.
        Integer 라이브러리의 compare 함수를 살펴보면 x==y 인 경우 0을 반환, x < y인 경우 음수, x > y인 경우 양수를 반환합니다.
        1020과 2010을 비교하면 x < y인 경우로, 음수를 반환합니다.
        이제 Integer.compare()로부터 나온 연산 결과를 Collections.sort() 내부의 comparator에서 사용하게 됩니다.
        comparator의 경우 음수는 오름차순, 양수는 내림차순으로 요소의 자리를 바꿔줍니다.
        그러나 위의 코드에서는 sb + ab는 인위적으로 자리 바꿈을 수행하였습니다.
        그러므로 (ab + sb) < (sb + ab)인 경우 자리바꿈을 수행해야하는 상황인겁니다. 문제의 조건에 부합하려면 20이 10보다 앞에 위치해야합니다.
        하지만 Integer.compare()함수에서 음수를 반환하고 이를 전달받은 Collections.sort()는 음수를 오름차순으로 정렬하므로 문제의 조건에 부합하지 않습니다.
        즉, Integer.compare()는 (ab + sb) < (sb + ab)인 경우에 음수를 반환하지만 sb가 ab보다 앞에 위치하도록 만들기 위해서
        Integer.compare() 앞에 마이너스(-) 부호를 붙여 양수를 반환하게 하여 Collections.sort()가 내림차순으로 정렬하도록 하는 것입니다.
         */
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();
        for (Integer i : list)
        {
            sb.append(i);
        }
        answer = sb.toString();
        if (answer.charAt(0) == '0')
        {
            return "0";
        }
        else
        {
            return answer;
        }
    }
}
