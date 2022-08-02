package Level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class DevFunc
{

    public static void main(String[] args)
    {
        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }

    //큐 이용
    public static int[] solution(int[] progresses, int[] speeds)
    {

        //progresses : 먼저 배포되어야 하는 순서대로 작업의 진도
        //speeds : 개발 속도
        //각 배포마다 몇 개의 기능이 배포되는지

        // 계산식 Math.ceil((100-progress)/speed)

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++)
        {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int day = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && day >= queue.peek())
            {
                cnt++;
                queue.poll();
            }

            answer.add(cnt);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    //배열 이용
    public static int[] solution2(int[] progresses, int[] speeds)
    {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
