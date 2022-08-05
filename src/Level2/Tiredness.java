package Level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
public class Tiredness
{
    boolean[] visit;
    int[][] dungeons;
    int answer = 0;
    public static void main(String[] args)
    {

    }

    public int solution(int k, int[][] dungeons)
    {
        // k : 현재 피로도
        // dungeons : [필요 피로도, 소모 피로도]
        this.dungeons = dungeons;
        visit = new boolean[dungeons.length];

        for(int i=0; i<dungeons.length; i++)
        {
            if(k>= dungeons[i][0])
            {
                dfs(i,k,1);
            }
        }

        return answer;
    }

    // 던전idx, 남은 피로도, 던전 진행 수
    public void dfs(int cur, int tired, int depth)
    {
        visit[cur] = true;
        tired -= dungeons[cur][1];
        for(int i=0; i<dungeons.length; i++)
        {
            if(!visit[i] && dungeons[i][0] <= tired)
            {
                dfs(i,tired,depth+1);
            }
        }
        answer = Math.max(depth, answer);
        visit[cur] = false;
    }
}
