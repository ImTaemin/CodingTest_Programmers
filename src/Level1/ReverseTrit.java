package Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class ReverseTrit
{
    public static void main(String[] args)
    {
        solution(45);
    }

    // 메모리 초과
    /*public static int solution(int n)
    {
        int answer = 0;

        List<Integer> tritList = new ArrayList<>();
        while (true)
        {
            tritList.add(n % 3);
            n = n / 3;
            if (n == 1)
            {
                tritList.add(1);
                break;
            }
        }

        for (int i = tritList.size() - 1, j = 0; i >= 0; i--, j++)
            answer += tritList.get(j) * Math.pow(3, i);

        return answer;
    }*/

    // 스택을 이용한 방법
    public static int solution(int n)
    {
        int answer = 0;

        Stack<Integer> tritStack = new Stack<>();
        while (true)
        {
            tritStack.add(n % 3);
            n = n / 3;
            if (n == 0) break;
        }

        for (int i = 0, size = tritStack.size(); i < size; i++)
            answer += tritStack.pop() * (Math.pow(3, i));

        return answer;
    }

    // 다른 사람의 풀이
    public int solution1(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a; // a - a+(n%3) 하면 뒤집기 안해도 됨.
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3); // 3진법 변환
    }
}
