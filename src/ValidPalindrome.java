/**
 * https://oj.leetcode.com/problems/valid-palindrome/
 * <p/>
 * Created by Penny on 2014/11/20
 */
public class ValidPalindrome {
    /**
     * 分别从左和右开始扫描，如果是有效的字符，则进行比较（忽略大小写），只需要比较一半即可
     */
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
