package Level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java
public class Carpet
{
    public static void main(String[] args)
    {
        solution(10,2);
    }

    public static int[] solution(int brown, int yellow)
    {
        // brown : 갈색 격자의 수
        // yellow : 노란색 격자의 수
        // 카펫의 가로 세로 크기르 순서대로 배열에 담아 리턴

        /*
        1. 행과 열의 개수가 3이상
        2. brown 개수와 yellow 개수를 합치면 return 개수의 곱과 같음
        3. 카펫의 가로 길이는 세로 길이와 같거나, 큼
        4. return = 가로-2 * 세로-2 == yellow
         */
        int[] answer = new int[2];
        int sum = brown + yellow;

        // 행,열의 개수는 3이상이여야 함
        for (int i = 3; i < sum; i++)
        {
            int col = i;
            int row = sum / i;

            if(row < 3) continue;

            // 행은 열보다 크거나 같아야 함
            if(row >= col)
            {
                if((row-2) * (col-2) == yellow)
                {
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                }
            }
        }
        return answer;
    }
}
