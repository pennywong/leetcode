/**
 * Created by Penny on 2015/01/07
 */
public class UniqueBinarySearchTrees {
    /**
     * 参考：http://blog.csdn.net/dacxu/article/details/25814577
     * <p/>
     * http://blog.csdn.net/linhuanmars/article/details/24761459
     */
    public int numTrees(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++)
                a[i] += a[j] * a[i - j - 1];
        }

        return a[n];
    }
}
