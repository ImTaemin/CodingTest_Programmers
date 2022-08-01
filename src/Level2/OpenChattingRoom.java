package Level2;

import java.util.*;

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
        List<String> result = new ArrayList<>();

        String[][] users = new String[record.length][3];
        HashMap<String, String> userNameMap = new HashMap<>();

        for(int i=0; i<record.length; i++)
        {
            String[] temp = record[i].split(" ");
            if(temp.length == 2)
            {
                // uid, 상태
                users[i] = new String[]{temp[1], temp[0]};
                continue;
            }
            users[i] = new String[]{temp[1], temp[0], temp[2]};
            userNameMap.put(temp[1], temp[2]);
        }

        // 전체 총 유저
        for(int i=0; i<users.length; i++)
        {
            if(users[i][1].equals("Change")) continue;

            // 나간상태
            if(users[i].length == 2)
            {
                result.add(userNameMap.get(users[i][0]) + "님이 나갔습니다.") ;
                continue;
            }
            
            if(users[i][1].equals("Enter"))
            {
                result.add(userNameMap.get(users[i][0]) + "님이 들어왔습니다.");
            }
        }

        int size = result.size();
        answer = new String[size];

        for(int i=0; i<size; i++)
        {
            answer[i] = result.get(i);
        }

        return answer;
    }
    
    // 다른 사람의 풀이
    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";

    private HashMap<String, UserInfo> userMap = new HashMap<>();

    private class UserInfo {
        public String userId;
        public String nickName;

        public UserInfo(String userId, String nickName) {
            this.userId = userId;
            this.nickName = nickName;
        }

    }

    private class Command {
        public char command;
        public String userId;

        public Command(char command, String userName) {
            this.command = command;
            this.userId = userName;
        }
    }


    public String[] solution2(String[] records) {
        ArrayList<Command> commandList = new ArrayList<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String userId = split[1];
            String nickName = "";

            switch(command.charAt(0)) {
                case 'E': // Enter
                    nickName = split[2];
                    if(userMap.containsKey(userId) == false) {
                        userMap.put(userId, new UserInfo(userId, nickName));
                    } else {
                        userMap.get(userId).nickName = nickName;
                    }

                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'L': // Leave
                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'C': // Change
                    nickName = split[2];
                    userMap.get(userId).nickName = nickName;
                    break;
            }
        }

        return commandList.stream()
                .map(cmd -> String.format( cmd.command == 'E' ? ENTER_FORMAT : LEAVE_FORMAT , userMap.get(cmd.userId).nickName))
                .toArray(ary -> new String[commandList.size()]);
    }
}
