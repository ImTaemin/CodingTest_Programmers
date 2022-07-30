package Level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class PhoneKemon
{
    public static void main(String[] args)
    {
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }

    public static int solution(int[] nums) {
        Set<Integer> types = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));

        int pickSize = nums.length/2; //3
        int typeSize = types.size(); //4 // 2
        if(pickSize <= typeSize)
        {
            return pickSize;
        }
        else if(pickSize > typeSize)
        {
            return typeSize;
        }
        return 0;
    }
}
