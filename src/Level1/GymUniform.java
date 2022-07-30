package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
public class GymUniform
{
    public static void main(String[] args)
    {
        solution(5, new int[]{2,4}, new int[]{1,3,5});
//        solution(5, new int[]{2, 4}, new int[]{3}); //4
    }

    // 내가 한 방법(정확성 75점으로 실패)
    /*
    public static int solution(int n, int[] lost, int[] reserve)
    {
        Map<Integer, Boolean> reserveMap = new HashMap<>();

        int lostLength = lost.length;
        int reserveLength = reserve.length;
        for (int i = 0; i < reserveLength; i++)
        {
            reserveMap.put(reserve[i], true);
        }

        for (int i = 0; i < lostLength; i++)
        {
            for (int j = 0; j < reserveLength; j++)
            {
                boolean preReserve = reserveMap.getOrDefault(lost[i] - 1, false);
                if (preReserve == true)
                {
                    reserveMap.replace(lost[i] - 1, false);
                    break;
                }

                if (preReserve == false)
                {
                    boolean nextReserve = reserveMap.getOrDefault(lost[i] + 1, false);
                    if (!nextReserve)
                    {
                        n--;
                        break;
                    }
                    else
                    {
                        reserveMap.replace(lost[i] + 1, false);
                        break;
                    }
                }

                if(lost[i] == reserve[j] && reserveMap.get(lost[i]));
                {
                    reserveMap.replace(lost[i], false);
                    break;
                }
            }
        }
        return n;
    }
     */

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //lost[] 와 reserve[] 배열의 요소값을 0 이 아닌 -1로 변경해주는 이유는
        //0으로 변경했을 경우 lost[i]+1 의 값이 1 이 되므로 if문을 타게 될 가능성이 있다.

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }


}
