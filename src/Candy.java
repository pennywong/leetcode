/**
 * https://oj.leetcode.com/problems/candy/
 * <p/>
 * Created by Penny on 2015/01/28
 */
public class Candy {
    public int candy(int[] ratings) {
        int sum = 0;
        int mark = 0;
        int last = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i == ratings.length - 1 || ratings[i + 1] >= ratings[i]) {
                if (i == mark) {
                    if (i == 0 || ratings[i] == ratings[i - 1])
                        last = 1;
                    else
                        last++;
                    sum += last;
                } else {
                    int n = i - mark;
                    sum += n * (n + 1) / 2;
                    if (mark > 0 && ratings[mark] > ratings[mark - 1] && (n + 1) <= last)
                        sum += (last + 1);
                    else
                        sum += (n + 1);
                    last = 1;
                }

                mark = i + 1;
            }
        }

        return sum;
    }

    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int[] candy = new int[ratings.length];
        int index = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i == ratings.length - 1 || ratings[i + 1] >= ratings[i]) {
                if (i == index) {
                    if (i == 0 || ratings[i] == ratings[i - 1])
                        candy[i] = 1;
                    else
                        candy[i] = candy[i - 1] + 1;
                } else {
                    for (int j = i, count = 1; j >= index; j--, count++)
                        candy[j] = count;
                    if (index > 0 && ratings[index] > ratings[index - 1] && candy[index] <= candy[index - 1])
                        candy[index] = candy[index - 1] + 1;
                }

                index = i + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < candy.length; i++)
            sum += candy[i];

        return sum;
    }
}
