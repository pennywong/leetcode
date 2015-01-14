import java.util.Arrays;

/**
 * Created by Penny on 2015/01/14
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int closest = 0;
        int min = Integer.MAX_VALUE;

        if (num == null || num.length == 0)
            return Integer.MAX_VALUE;

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
                int diff = sum - target;
                if (diff == 0)
                    return sum;

                if (min > Math.abs(diff)) {
                    min = Math.abs(diff);
                    closest = sum;
                }

                if (diff > 0)
                    q--;
                else
                    p++;
            }
        }

        return closest;
    }
}
