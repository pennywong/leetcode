/**
 * https://oj.leetcode.com/problems/gas-station/
 * <p/>
 * Created by Penny on 2015/01/13
 */
public class GasStation {
    /**
     * 参考：http://blog.csdn.net/fytain/article/details/12191103
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int remain = gas[0] - cost[0];
        int i = 1;

        while (start != i && i < gas.length) {
            if (remain >= 0) {
                remain += gas[i] - cost[i];
                i++;
            } else {
                start--;
                if (start < 0)
                    start = gas.length - 1;
                remain += gas[start] - cost[start];
            }
        }

        if (remain >= 0)
            return start;
        else
            return -1;
    }
}
