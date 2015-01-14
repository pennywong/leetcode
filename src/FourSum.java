import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/4sum/
 * <p/>
 * Created by Penny on 2015/01/14
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num == null || num.length == 0)
            return result;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;

                int p = j + 1;
                int q = num.length - 1;

                while (p < q) {
                    if (p > j + 1 && num[p] == num[p - 1]) {
                        p++;
                        continue;
                    }
                    if (q < num.length - 1 && num[q] == num[q + 1]) {
                        q--;
                        continue;
                    }

                    int sum = num[i] + num[j] + num[p] + num[q];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[p]);
                        list.add(num[q]);
                        result.add(list);

                        p++;
                        q--;
                    } else if (sum > target)
                        q--;
                    else
                        p++;
                }
            }
        }

        return result;
    }
}
