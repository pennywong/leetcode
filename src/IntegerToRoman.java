/**
 * https://oj.leetcode.com/problems/integer-to-roman/
 * <p/>
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    /**
     * 罗马数字规则参考：http://baike.baidu.com/view/42061.htm
     * 数字都非常有规则，I V X D C M，每个位上都是最小的可以从1到3，然后4则是中间的加上最小的，
     * 然后6-8则是中间的加上最小的，最后9是最小的加上最大的
     * <p/>
     * 其实最简单的方法将各个位的所有数字都列出来，然后每个位对应一下即可
     * List<String> thousand = {'M','MM','MMM'}
     * List<String> hundred = {'C','CC','CCC','CD','D','DC','DCC','DCCC','CM'}
     * List<String> ten = {'X','XX','XXX','XL','L','LX','LXX','LXXX','XC'}
     * List<String> unit = {'I','II','III','IV','V','VI','VII','VIII','IX'}
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        sb.append(convert(num / 1000, 'M', 'M', 'M'));
        num = num % 1000;

        sb.append(convert(num / 100, 'C', 'D', 'M'));
        num = num % 100;

        sb.append(convert(num / 10, 'X', 'L', 'C'));
        num = num % 10;

        sb.append(convert(num, 'I', 'V', 'X'));

        return sb.toString();
    }

    private String convert(int num, char min, char mid, char max) {
        if (num == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        if (num <= 3) {
            for (int i = 0; i < num; i++)
                sb.append(min);
        } else if (num == 4)
            sb.append(min).append(mid);
        else if (num == 5)
            sb.append(mid);
        else if (num < 9) {
            sb.append(mid);
            for (int i = 0; i < num - 5; i++)
                sb.append(min);
        } else
            sb.append(min).append(max);

        return sb.toString();
    }
}
