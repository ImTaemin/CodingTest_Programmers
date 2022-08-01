package Level3;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class BestAlbum
{
    public static void main(String[] args)
    {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop" }, new int[]{500, 600, 150, 800, 2500});
    }


    public static int[] solution(String[] genres, int[] plays)
    {
        // 순위
        // 1. 많이 재생된 장르
        // 2. 장르 내에서 많이 재생된 노래
        // 3. 장르 내에서 재생 횟수가 같으면 고유 번호가 낮은 노래 먼저

        ArrayList<Integer> answer = new ArrayList<>();

        // <장르, 총 재생횟수>
        Map<String, Integer> numMap = new HashMap<>();
        // <장르, <고유번호, 재생횟수>>
        Map<String, HashMap<Integer, Integer>> playCntMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++)
        {
            if(numMap.containsKey(genres[i]))
            {
                playCntMap.get(genres[i]).put(i, plays[i]);
                numMap.put(genres[i], numMap.get(genres[i]) + plays[i]);
            }
            else
            {
                // 장르별 재생 횟수 저장
                numMap.put(genres[i], plays[i]);

                // 장르에 속한 <고유번호, 재생횟수> 저장
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(i, plays[i]);
                playCntMap.put(genres[i], tmp);
            }
        }

        //장르 내에서 많이 재생된 노래를 먼저 수록 -> 내림차순 정렬.
        ArrayList<String> genreList = new ArrayList<>(numMap.keySet());
        Collections.sort(genreList, (v1, v2) -> numMap.get(v2) - numMap.get(v1));

        for (String genre : genreList)
        {
            HashMap<Integer, Integer> uidCntMap = playCntMap.get(genre);
            List<Integer> uidCntList = new ArrayList<>(uidCntMap.keySet());

            Collections.sort(uidCntList, (v1, v2) -> uidCntMap.get(v2) - uidCntMap.get(v1));

            answer.add(uidCntList.get(0));
            if (uidCntList.size() > 1)
            {
                answer.add(uidCntList.get(1));
            }
        }

        System.out.println(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
