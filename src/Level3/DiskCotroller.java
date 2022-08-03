package Level3;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=java
public class DiskCotroller
{
    public static void main(String[] args)
    {
        solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
    }

    public static int solution(int[][] jobs)
    {
        /*
        요청이 들어온 순서
        ┌─────────────────────────────────────┐
        │0123456789 10 11 12 13 14 15 16 17 18│
        ├─────────────────────────────────────┤
        │AAAA                                 │
        │ BBBBBBBBB B                         │
        │  CCCCCCC                            │
        └─────────────────────────────────────┘
        - 0ms 시점에 3ms가 소요되는 A작업 요청
        - 1ms 시점에 9ms가 소요되는 B작업 요청
        - 2ms 시점에 6ms가 소요되는 C작업 요청

        -----   요청 받은 순서대로 처리 시   ------
        ┌─────────────────────────────────────┐
        │0123456789 10 11 12 13 14 15 16 17 18│
        ├─────────────────────────────────────┤
        │AAAA                                 │
        │   BBBBBBB B  B  B                   │
        │                 C  C  C  C  C  C  C │
        └─────────────────────────────────────┘
        ** 각 작업의 요청 ~ 종료까지의 평균 = 10ms((3+11+16)/3) **
        - A: 3ms 시점에 작업 완료 (요청 ~ 종료 : 3ms)
        - B: 1ms 대기, 3ms ~ 12ms 시점에 작업 완료(요청 ~ 종료 : 11ms)
        - C: 2ms 대기, 12ms ~ 18ms 시점에 작업 완료(요청 ~ 종료 : 16ms)

        ──────────────────────────────────────

        -----   A->C->B 순서대로 처리 시   ------
        ┌─────────────────────────────────────┐
        │0123456789 10 11 12 13 14 15 16 17 18│
        ├─────────────────────────────────────┤
        │AAAA                                 │
        │         B  B  B  B  B  B  B  B  B  B│
        │   CCCCCCC                           │
        └─────────────────────────────────────┘
        ** 각 작업의 요청 ~ 종료까지의 평균 = 9ms((3+7+17)/3) **
        - A: 3ms 시점에 작업 완료(요청 ~ 종료 : 3ms)
        - C: 2ms 대기, 3ms ~ 9ms 시점에 작업 완료(요청 ~종료 : 7ms)
        - B: 1ms 대기, 9ms ~ 18ms 시점에 작업 완료(요청 ~ 종료 : 17ms)
         */

        // jobs : [작업이 요청되는 시점, 작업의 소요시간]
        // 평균을 가장 줄이는 방법으로 처리 시 평균시간 반환

        int answer = 0;
        int end = 0; // 작업이 수행된 후의 시간
        int jobsIdx = 0; // jobs 배열 인덱스
        int cnt = 0;

        // 요청 시간 오름차순 정렬
        Arrays.sort(jobs, (v1, v2) -> v1[0] - v2[0]);

        // 처리 시간으로 오름차순 정렬되는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);

        while (cnt < jobs.length)
        {
            // 한 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣음
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end)
            {
                pq.add(jobs[jobsIdx++]);
            }

            // 큐가 비어있으면 작업 완료 후에 다시 요청이 들어온다는 의미
            // end를 요청의 가장 처음으로 맞춰준다.
            if (pq.isEmpty())
            {
                end = jobs[jobsIdx][0];
            }
            else
            {
                // 작업이 끝나기 전(end 이전) 들어온 요청 중 수행시간이 가장 짧은 요청먼저 수행
                int[] job = pq.poll();
                answer += job[1] + end - job[0];
                end += job[1];
                cnt++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}
