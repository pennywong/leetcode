import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 * <p/>
 * Created by Penny on 2015/01/29
 */
public class MaxPointsOnALine {
    /**
     * 参考：http://blog.csdn.net/doc_sgl/article/details/17103427
     */
    public int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int duplicate = 1;
            int tempMax = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y)
                        duplicate++;
                    else {
                        Integer count = map.get((double) Integer.MAX_VALUE);
                        if (count == null)
                            count = 1;
                        else
                            count++;
                        map.put((double) Integer.MAX_VALUE, count);
                        tempMax = Math.max(tempMax, count);
                    }
                } else {
                    double k = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                    Integer count = map.get(k);
                    if (count == null)
                        count = 1;
                    else
                        count++;
                    map.put(k, count);
                    tempMax = Math.max(tempMax, count);
                }
            }

            max = Math.max(max, tempMax + duplicate);
        }

        return max;
    }
}
