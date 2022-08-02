package Level1;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class HateSameNum
{
    public static void main(String[] args)
    {
        solution(new int[]{1,1,3,3,0,1,1});
    }

    // 내가 한 풀이
    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int lastNum = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(stack.isEmpty())
            {
                stack.push(arr[i]);
                continue;
            }
            if(stack.peek() == arr[i])
            {
                continue;
            }
            else
            {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1; i>=0; i--)
        {
            answer[i] = stack.pop();
        }
        return answer;
    }

    // 다른 사람이 한 풀이(ArrayList)
    public static int[] solution1(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}
