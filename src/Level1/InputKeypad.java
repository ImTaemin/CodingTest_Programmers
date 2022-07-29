package Level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=java
public class InputKeypad
{
    public static void main(String[] args)
    {
        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }

    public static String solution(int[] numbers, String hand) {

        int lastLeftHand = 10;
        int lastRightHand = 12;

        StringBuilder sb = new StringBuilder();
        for(int num : numbers)
        {
            if(num == 0) {num = 11;}

            int tmp = num % 3;
            if(tmp == 0)
            {
                // 오른손 입력
                lastRightHand = num;
                sb.append("R");
            }
            else if(tmp == 1)
            {
                // 왼손입력
                lastLeftHand = num;
                sb.append("L");
            }
            else
            {
                int leftDis = Math.abs(lastLeftHand - num) / 3 + Math.abs(lastLeftHand - num) % 3; //ex (8-2)/3=2 + (8-2)%3=0
                int rightDis = Math.abs(lastRightHand - num) / 3 + Math.abs(lastRightHand - num) % 3; // ex (5-2)/3=1 + (5-2)%3=0

                if(leftDis > rightDis)
                {
                    lastRightHand = num;
                    sb.append("R");
                }
                else if(leftDis < rightDis)
                {
                    lastLeftHand = num;
                    sb.append("L");
                }
                else {
                    if("right".equals(hand))
                    {
                        lastRightHand = num;
                        sb.append("R");
                    }
                    else
                    {
                        lastLeftHand = num;
                        sb.append("L");
                    }
                }
            }
        }

        System.out.println(sb);
        return sb.toString();
    }
}
