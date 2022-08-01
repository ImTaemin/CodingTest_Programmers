package Level2;

import java.util.*;

import static java.util.stream.Collectors.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42578
public class Camouflage
{
    public static void main(String[] args)
    {
        solution(new String[][]{{"yellow_hat", "headgear" }, {"blue_sunglasses", "eyewear" }, {"green_turban", "headgear" }});
        solutionStream(new String[][]{{"yellow_hat", "headgear" }, {"blue_sunglasses", "eyewear" }, {"green_turban", "headgear" }});
    }

    public static int solution(String[][] clothes)
    {
        // 타입, 타입의 개수
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes)
        {
            String type = clothe[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        // 아무것도 입지 않은 경우를 포함한 경우의 수 계산
        int result = 1;
        for (int i : clothesMap.values())
        {
            // 모든 타입에 대해서 안 입는 경우가 있음
            result = result * (i + 1);
        }

        // 아무것도 입지 않은 경우 제외
        return result - 1;
    }

    // 다른 사람의 코드
    public static int solutionStream(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting()))) //p0(타입)에 대해 p1카운팅
                .values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }
}
