import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/merge-intervals/
 * <p/>
 * Created by Penny on 2015/01/22
 */
public class MergeIntervals {
    /**
     * 参考：http://blog.csdn.net/perfect8886/article/details/21783299
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return list;

        Interval[] array = intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(array, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval interval = array[0];
        for (int i = 1; i < array.length; i++) {
            if (interval.end < array[i].start) {
                list.add(interval);
                interval = array[i];
            } else {
                interval.end = Math.max(interval.end, array[i].end);
            }
        }
        list.add(interval);

        return list;
    }
}
