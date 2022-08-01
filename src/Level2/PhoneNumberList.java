package Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList
{
    public static void main(String[] args)
    {
        solution(new String[]{"119", "97674223", "1195524421" });
    }

    // 정렬 후 단순비교
    public static boolean solution(String[] phone_book)
    {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++)
        {
            if (phone_book[i + 1].startsWith(phone_book[i]))
            {
                answer = false;
                break;
            }
        }
        return answer;
    }

    // 해시 사용
    public static boolean solutionHash(String[] phone_book)
    {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++)
        {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++)
        {
            for (int j = 0; j < phone_book[i].length(); j++)
            {
                if (map.containsKey(phone_book[i].substring(0, j)))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
