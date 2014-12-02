/**
 * https://oj.leetcode.com/problems/roman-to-integer/
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     * 罗马数字规则参考：http://baike.baidu.com/view/42061.htm
     * <p/>
     * 简单来说从左到右，相同的则暂时累加，如果左边的大于右边，加上之前累加的，但右边的计到下次的累加中，
     * 否则如果左边的少于右边的，则则右边的当前数字减去之前累加的，然后重新开始算
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int temp = map.get(s.charAt(0));
        int pre = temp;
        for (int i = 1; i < s.length(); i++) {
            int now = map.get(s.charAt(i));
            if (pre == 0) {
                pre = now;
                temp = now;
            } else {
                if (pre < now) {
                    result += (now - temp);
                    temp = 0;
                    pre = 0;
                } else if (pre > now) {
                    result += temp;
                    temp = now;
                    pre = now;
                } else {
                    temp += now;
                }
            }

        }

        result += temp;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("XII"));
        System.out.println(romanToInt("XVII"));
        System.out.println(romanToInt("CMXCIX"));
        System.out.println(romanToInt("MMMCMXCIX"));
    }
}
