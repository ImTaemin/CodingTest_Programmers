package Level1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
public class UnFinishedRunner
{
    public static void main(String[] args)
    {
        // 동명이인 존재
//        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
//        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }

    public static String solution(String[] participant, String[] completion) {
        // participant : 참여자들
        // completion : 완주자들
        String answer = "";

        // 1. 정렬 후 탐색
        /*
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;
        for(; i< completion.length; i++)
        {
            if(!participant[i].equals(completion[i]))
            {
                break;
            }
        }
        // 마지막 주자가 완주 못한 상태
        return participant[i];
         */

        // 2. 해시
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("a", 2);
        for(String p : participant)
        {
            // 동명이인을 가리기 위해 +1
            map.put(p, map.getOrDefault(p, 0) + 1);  //marina:0 , josipa:0 , nikola:0 , vinko:0 , filipa:0
        }
        for(String c : completion)
        {
            map.put(c, map.get(c)-1); // josipa:-1, filipa:-1, marina:-1, nikola:-1, vinko:0
        }

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() != 0)
            {
                answer = entry.getKey();
                break;
            }
        }
        return answer;

       // 효율성 테스트 탈락
        /*
        String answer = "";
        for(int i=0; i< completion.length; i++)
        {
            for(int j=0; j< participant.length; j++)
            {
                if(completion[i].equals(participant[j]))
                {
                    participant[j] = "0";
                    break;
                }
            }
        }

        for(String tmp : participant)
        {
            if(!tmp.equals("0"))
            {
                return tmp;
            }
        }

        return answer;

         */
    }
}
