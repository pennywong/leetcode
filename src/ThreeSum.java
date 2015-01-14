import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/3sum/
 * <p/>
 * Created by Penny on 2015/01/14
 */
public class ThreeSum {
    /**
     * 参考：http://blog.csdn.net/zhouworld16/article/details/16917071
     * http://blog.csdn.net/nanjunxiao/article/details/12524405
     */
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num == null || num.length == 0)
            return result;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            int p = i + 1;
            int q = num.length - 1;

            while (p < q) {
                if (p > i + 1 && num[p] == num[p - 1]) {
                    p++;
                    continue;
                }
                if (q < num.length - 1 && num[q] == num[q + 1]) {
                    q--;
                    continue;
                }

                int sum = num[i] + num[p] + num[q];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[p]);
                    list.add(num[q]);
                    result.add(list);

                    p++;
                    q--;
                } else if (sum > 0)
                    q--;
                else
                    p++;
            }
        }

        return result;
    }
}
