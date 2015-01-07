/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 * <p/>
 * Created by Penny on 2015/01/07
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.equals(""))
            return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }
}
