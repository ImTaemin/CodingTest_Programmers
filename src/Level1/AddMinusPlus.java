package Level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=java
public class AddMinusPlus
{
    public static void main(String[] args)
    {
        solution(new int[]{4,7,12}, new boolean[]{true,false,true});
    }

    public static int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;
        for(int i=0, length=absolutes.length; i<length; i++)
        {
            if(signs[i])// true면 더하기
            {
                answer += absolutes[i];
            }
            else
            {
                answer -= absolutes[i];
            }
        }
        System.out.println(answer);

        return answer;
    }
}
