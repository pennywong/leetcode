/**
 * https://oj.leetcode.com/problems/container-with-most-water/
 * <p/>
 * Created by Penny on 2015/01/08
 */
public class ContainerWithMostWater {
    /**
     * 参考：https://oj.leetcode.com/problems/container-with-most-water/
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int h = height[i] < height[j] ? height[i] : height[j];
            int area = (j - i) * h;
            if (max < area)
                max = area;
            if (height[i] <= height[j])
                i++;
            else
                j--;
        }

        return max;
    }
}
