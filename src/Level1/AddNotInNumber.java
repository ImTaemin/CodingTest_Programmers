package Level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=java
public class AddNotInNumber
{
    public static void main(String[] args)
    {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8};
        solution(numbers);
    }

    public static int solution(int[] numbers)
    {
        int cnt = 0;
        for(int n : numbers)
            cnt += n;

        return 45 - cnt ;
    }
}
