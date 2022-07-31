package Level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class CompressString
{
    public static void main(String[] args)
    {
        solution("aabbaccc");
    }

    // 안됨..
    public static int solution(String s)
    {
        /*
        2, 3, 4크기로 압축하는 경우 substring() 메서드의 인자로 들어가는 순서는
        2일 때 (0,2) (2,4)... 3일 때 (0,3) (3,6)... 4일 때 (0,4) (4,8)....

        substring()으로 자른 문자열들을 비교해 같은 개수만큼 카운팅하여
        개수+자른 문자열로 압축하는 과정을 거친다
        카운팅이 1개인(압축이 안 되는) 경우는 예외처리로 자른 문자열만 붙여줘야 한다.
         */

        // 최소 문자열을 찾기 위한 변수
        int answer = Integer.MAX_VALUE;

        // 문자열 길이가 1인 경우는 압축 불가로 1 반환
        if (s.length() == 1) return 1;

        // 문자열 압축 단위  ※길이/2를 넘으면 압축 불가
        for (int i = 1; i <= s.length() / 2; i++)
        {
            String str = ""; // 길이 별 압축된 문자열
            String temp = ""; // 자른 문자열을 비교하기 위한 변수
            int count = 1; // 자른 문자열 중 같은 문자열 카운팅

            for (int j = 0; j < s.length() / i; j++)
            {
                // 이전에 자른 문자열과 현재 자른 문자열이 같으면 카운팅
                if (temp.equals(s.substring(j * i, (j * i) + 1)))
                {
                    count++;
                    continue;
                }

                // 카운팅 > 1 인 경우 count + temp 후 count 초기화
                if (count > 1)
                {
                    str += count + temp;
                    count = 1;
                }
                // 나머지 경우는 자른 문자열(temp)만 붙여줌
                else
                {
                    str += temp;
                }

                // 현재 자른 문자열로 변경
                temp = s.substring(j * i, (j * i) + i);
            }

            // 마지막에 못 붙인 문자열 붙임
            if (count > 1)
            {
                str += count + temp;
                count = 1;
            }
            else
            {
                str += temp;
            }

            // s의 길이가 압축하는 길이로 나누어 떨어지지 않으면
            // 나머지 부분부터 마지막까지 substring을 이용해 붙임
            if (s.length() % i != 0)
            {
                str += s.substring(s.length() - s.length() % i, s.length());
            }

            // 가장 짧은 길이를 찾음
            answer = answer > str.length() ? str.length() : answer;
        }

        return answer;
    }

    public static int solutionString(String s)
    {
        int answer = Integer.MAX_VALUE;
        int len = s.length();

        if (len == 1) return 1;

        for (int r = 1; r <= len / 2; r++)
        {
            String pattern = s.substring(0, r);
            int cnt = 1;
            String reStr = "";
            for (int i = r; i <= len - r; i += r)
            {
                if (pattern.equals(s.substring(i, i + r)))
                {
                    cnt++;
                }
                else
                {
                    if (cnt > 1)
                    {
                        reStr += cnt + "";
                    }
                    reStr += pattern;
                    pattern = s.substring(i, i + r);
                    cnt = 1;
                }
            }

            if (cnt > 1)
            {
                reStr += "" + cnt;
            }
            reStr += pattern;

            int div = s.length() % r;
            answer = Math.min(answer, reStr.length() + div);
        }
        return answer;
    }

    // 속도 훨씬 빠름
    public int solutionInteger(String s)
    {
        int answer = Integer.MAX_VALUE;
        int len = s.length();

        if (len == 1) return 1;
        for (int r = 1; r <= len / 2; r++)
        {
            String pattern = s.substring(0, r);
            int compLen = 0;
            int cnt = 1;
            for (int i = r; i <= len - r; i += r)
            {
                if (pattern.equals(s.substring(i, i + r)))
                {
                    cnt++;
                }
                else
                {
                    if (cnt > 1)
                    {
                        compLen += (int) Math.log10(cnt) + 1;
                    }
                    pattern = s.substring(i, i + r);
                    compLen += pattern.length();
                    cnt = 1;
                }
            }

            if (cnt > 1)
            {
                compLen += (int) Math.log10(cnt) + 1;
            }

            int div = len % r;
            if (div > 0) compLen += div;
            compLen += pattern.length();

            answer = Math.min(answer, compLen);
        }

        System.out.println(answer);
        return answer;
    }

    // 재귀
    public int solutionRecursive(String s)
    {
        int answer = 0;

        for (int i = 1; i <= (s.length() / 2) + 1; i++)
        {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : (Math.min(answer, result));
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat)
    {
        if (s.length() < n) return s;

        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if (!postString.startsWith(preString))
        {
            if (repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat + 1);
    }
}
