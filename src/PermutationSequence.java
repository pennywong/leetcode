/**
 * https://oj.leetcode.com/problems/permutation-sequence/
 * <p/>
 * Created by Penny on 2015/01/22
 */
public class PermutationSequence {
    /**
     * 参考：http://blog.csdn.net/doc_sgl/article/details/12840715
     * http://blog.csdn.net/chen895281773/article/details/12357703
     */
    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++)
            stringBuilder.append(i);
        StringBuilder result = new StringBuilder();
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++)
            factor[i] = factor[i - 1] * i;
        k--;
        for (int i = n - 1; i > 0; i--) {
            int code = k / factor[i];
            k = k % factor[i];
            result.append(stringBuilder.charAt(code));
            stringBuilder.deleteCharAt(code);
        }
        result.append(stringBuilder.toString());

        return result.toString();
    }
}
