/**
 * https://oj.leetcode.com/problems/next-permutation/
 * <p/>
 * Created by Penny on 18/1/15.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        for (int i = num.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                    return;
                }
            }

            for (int k = i; k < num.length - 1; k++) {
                int temp = num[k];
                num[k] = num[k + 1];
                num[k + 1] = temp;
            }
        }
    }
}
