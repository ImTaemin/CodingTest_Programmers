package Level1;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java
public class Crane
{
    public static void main(String[] args)
    {
        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1},
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        solution(arr, moves);
    }

    public static int solution(int[][] board, int[] moves)
    {
        int cnt = 0;

        Stack<Integer> basket = new Stack<>();
        basket.push(0); // 맨 위 값과 비교하기 위해

        for(int crane : moves)
        {
            crane--; // 크레인위치
            for(int x = 0, length = board[crane].length; x < length; x++)
            {
                if(board[x][crane] == 0) continue;

                // 바스켓의 마지막과 같으면 상쇄
                if(basket.peek() == board[x][crane])
                {
                    basket.pop();
                    cnt += 2;
                }
                else
                {
                    basket.push(board[x][crane]);
                }
                board[x][crane] = 0;
                break;
            }
        }

        return cnt;
    }
}
