package Level1;

import java.util.ArrayList;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=java
public class FailureRate
{
    public static void main(String[] args)
    {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        solution(4, new int[]{4,4,4,4});
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 스테이지별 사용자의 수 저장
        int[] stagePersons = new int[N+1]; //5->6
        for(int i=0; i<N+1; i++)
        {
            int currentStage = 0;
            for(int j=0; j<stages.length; j++)
            {
                if(i+1 == stages[j])
                {
                    currentStage++;
                }
            }

            stagePersons[i] = currentStage;
        }

        int total = stages.length; // 사용자의 수

        // 실패율 저장
        double[] failRate = new double[N+1];
        for(int i=0; i<N+1; i++)
        {
            if(total == 0)
            {
                failRate[i] = 0;
            }
            else
            {
                failRate[i] = (double) stagePersons[i] / total;
            }
            total -= stagePersons[i];
        }

        for (double d : failRate)
            System.out.println(d);
        System.out.println();
        for (double s : stagePersons)
            System.out.println(s);
        return answer;
    }
}
