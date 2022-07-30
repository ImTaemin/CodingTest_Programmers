package Level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
public class KNum
{
    public static void main(String[] args)
    {
        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    public static int[] solution(int[] array, int[][] commands) {
        // array = [1, 5, 2, 6, 3, 7, 4];
        //   i, j, k    i  j  k    i, j, k ....
        // [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
        // return [5,6,3]
        int[] answer = new int[commands.length];

        for(int command=0; command < commands.length; command++)
        {
            int i = commands[command][0] -1; //2 ->1
            int j = commands[command][1] -1; //5 ->4
            int k = commands[command][2] -1; //3 ->2

            System.out.println("i:" + i + " j:" + j + " k:" + k);

            int[] arr = new int[j-i+1]; //4
            for(int x=0; x < arr.length; x++, i++)
            {
                arr[x] = array[i]; //0:5, 1:2, 2:6, 3:3
            }
            Arrays.sort(arr);
            answer[command] = arr[k];
        }
        return answer;
    }

    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
