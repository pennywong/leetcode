import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/insert-interval/
 * <p/>
 * Created by Penny on 2015/01/22
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new LinkedList<Interval>();
        int i = 0;
        while (i < intervals.size()) {
            Interval interval = intervals.get(i);

            if (interval.end < newInterval.start)
                list.add(interval);
            else if (newInterval.end < interval.start)
                break;
            else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }

            i++;
        }

        list.add(newInterval);

        while (i < intervals.size()) {
            list.add(intervals.get(i));
            i++;
        }

        return list;
    }
}
