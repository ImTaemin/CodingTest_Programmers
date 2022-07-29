package Level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class EngToNumString
{
    public static void main(String[] args)
    {
        solution("123");
    }

    public static int solution(String s)
    {
        String[] eng = {"zero", "one", "two", "three", "four", "five","six","seven","eight","nine"};

        for(int i=0, length=eng.length; i<length; i++)
        {
            s = s.replace(eng[i], Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
