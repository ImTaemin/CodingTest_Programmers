package Level2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChattingRoom
{
    public static void main(String[] args)
    {
        new OpenChattingRoom().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public String[] solution(String[] record)
    {
        String[] answer = {};

        StringBuilder result = new StringBuilder();

        // uid, name
        Map<String, String> nameMap = new HashMap<>();

        Map<String, String[]> userMap = new LinkedHashMap<>();
        for(String r : record)
        {
            String[] tmp = r.split(" ");
            if(tmp.length == 2)
            {
                userMap.put(tmp[1], new String[]{tmp[0], ""});
            }
            else
            {
                // < uid [상태,이름] >
                userMap.put(tmp[1], new String[]{tmp[0],tmp[2]});
                nameMap.put(tmp[1], tmp[2]);
            }
        }

        for(String uid : userMap.keySet())
        {
            String name = userMap.get(uid)[1];
            if(!name.equals(nameMap.get(uid)))
            {
                userMap.get(uid)[1] = nameMap.get(uid);
            }
            System.out.println(nameMap.get(uid));
        }

        for(String uid : userMap.keySet())
        {
            String state = userMap.get(uid)[0];
            if(state.equals("Enter"))
            {

            }
            if(state.equals("Change"))
            {
                // 이름변경
            }
            if(state.equals("Leave"))
            {

            }
        }


        return answer;
    }
}
