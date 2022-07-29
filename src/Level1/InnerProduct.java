package Level1;

public class InnerProduct
{
    public static void main(String[] args)
    {
        solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2});
    }

    public static int solution(int[] a, int[] b) {
        int cnt = 0;
        for(int i=0, length=a.length; i<length; i++)
        {
            cnt += (a[i])*(b[i]);
        }
        return cnt;
    }
}
