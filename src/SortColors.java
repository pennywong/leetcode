/**
 * https://oj.leetcode.com/problems/sort-colors/
 * <p/>
 * Created by Penny on 2014/12/12
 */
public class SortColors {
    public void sortColors(int[] A) {
        int[] counting = new int[3];

        for (int i = 0; i < A.length; i++)
            counting[A[i]]++;

        // 数字要连续
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (counting[i] > 0) {
                A[index] = i;
                index++;
                counting[i]--;
            }
        }
    }
}
