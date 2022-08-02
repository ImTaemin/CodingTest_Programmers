package Level2;

import java.util.Stack;

public class RightParenthesis
{
    public static void main(String[] args)
    {
        solution("(()(");
    }

    // 내가 한 풀이
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                stack.push('(');
            }
            else
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }
    
    // 다른 사람의 풀이
    boolean solution1(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}
