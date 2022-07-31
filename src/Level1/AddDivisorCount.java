package Level1;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class AddDivisorCount
{
    public static void main(String[] args)
    {
        solution(13,17);
    }

    public static int solution(int left, int right)
    {
        int answer = 0;

        for(int l = left; l<=right; l++)
        {
            int cnt = 1;
            for(int i=2; i<=l; i++)
                if (l % i == 0)
                    cnt++;

            if(cnt % 2 == 0)
                answer += l;
            else
                answer -= l;
        }
        return answer;
    }

    // 다른 사람의 풀이
 /*
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
    */
}
