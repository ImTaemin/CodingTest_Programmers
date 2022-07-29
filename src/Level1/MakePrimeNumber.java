package Level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=java
public class MakePrimeNumber
{
    public static void main(String[] args)
    {
        solution(new int[]{1, 2, 3, 4});
    }

    public static int solution(int[] nums)
    {
        int answer = 0;
        boolean chk = false; // 소수 체크

        for(int a=0; a<nums.length; a++)
        {
            for(int b=a+1; b<nums.length; b++)
            {
                for(int c=b+1; c<nums.length; c++)
                {
                    int num = nums[a] + nums[b] + nums[c];
                    if(num >= 2)
                    {
                        // 경우의 수
                        chk = primeCheck(num);
                    }

                    if(chk == true)
                    {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean primeCheck(int num)
    {
        boolean chk = true;
        if(num == 2)
        {
            return chk;
        }

        for(int i=2; i<num; i++)
        {
            if(num % i == 0)
            {
                chk = false;
                break;
            }
        }

        return chk;
    }
}
