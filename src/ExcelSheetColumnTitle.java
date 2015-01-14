/**
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 * <p/>
 * Created by Penny on 2015/01/13
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n != 0) {
            int x = n % 26;

            if (x == 0)
                x = 26;

            stringBuilder.append((char) (x - 1 + 'A'));

            n = (n - x) / 26;
        }

        return stringBuilder.reverse().toString();
    }
}
