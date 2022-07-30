package Level1;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=java
public class FailureRate
{
    public static void main(String[] args)
    {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        solution(4, new int[]{4,4,4,4});
    }

    public static int[] solution(int N, int[] stages)
    {
        int[] answer = new int[N];
        double users = stages.length;
        List<double[]> fail_rate = new ArrayList<>();

        int cnt = 0; // 스테이지에 해당하는 사람 수

        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j < stages.length; j++)
            {
                if (i == stages[j])
                {
                    cnt++;
                }
            }
            if (cnt == 0)
            {
                fail_rate.add(new double[]{i, 0});
                continue;
            }
            fail_rate.add(new double[]{i, cnt / users});
            users -= cnt;
            cnt = 0;
        }

        fail_rate.sort((a, b) -> Double.compare(b[1], a[1]));
        /*
        // 위 코드와 동일
        Comparator<double[]> comparator = new Comparator<double[]>()
        {
            @Override
            public int compare(double[] a, double[] b)
            {
                if (a[1] > b[1])
                {
                    return -1;
                }
                else if (a[1] == b[1])
                {
                    return Double.valueOf(a[0]).compareTo(Double.valueOf(b[0]));
                }
                else
                {
                    return 1;
                }
            }
        };

        Collections.sort(fail_rate,comparator);
        */

        for (int i = 0; i < fail_rate.size(); i++)
        {
            answer[i] = (int) fail_rate.get(i)[0];
        }

        return answer;
    }

    // 실패율, 사용자별 스테이지 번호까진 출력함...(실패)
    /*
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 스테이지별 사용자의 수 저장
        int[] stagePersons = new int[N+1];
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
        Double[] failRate = new Double[N+1];
        for(int i=0; i<N+1; i++)
        {
            if(total == 0)
            {
                failRate[i] = 0.0;
            }
            else
            {
                failRate[i] = (double) stagePersons[i] / total;
            }
            total -= stagePersons[i];
        }

          //실패율 역순
//        Arrays.sort(failRate, Collections.reverseOrder());

        return answer;
    }
    */
}
