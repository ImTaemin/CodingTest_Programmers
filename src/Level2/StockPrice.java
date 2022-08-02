package Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StockPrice
{
    public static void main(String[] args)
    {
        solution1(new int[]{1, 2, 3, 2, 3});
    }

    // 내가 한 풀이 (큐 이용) (1개 케이스만 성공 나머지 실패)
    public static int[] solution(int[] prices)
    {
        // prices : 초 단위로 기록된 주식가격
        // 가격이 떨어지지 않은 기간 몇 초인지
        int[] answer = {prices.length};

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < prices.length; i++)
        {
            queue.add(prices[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty())
        {
            int price = queue.poll();
            int cnt = 0;

            for (int i = prices.length - queue.size(); i < prices.length; i++)
            {
                if (price <= prices[i])
                {
                    cnt++;
                }
            }
            result.add(cnt);
        }
        System.out.println(result);
        return result.stream().mapToInt(v -> v).toArray();
    }

    // 다른 사람의 풀이 (스택 이용)
    public static int[] solution1(int[] prices)
    {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++)
        {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()])
            {
                // 떨어진 주식
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
        while (!stack.isEmpty())
        {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
    
    // 배열 이용
    public int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }

}
