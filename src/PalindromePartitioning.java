import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 * <p/>
 * Created by Penny on 2015/01/14
 */
public class PalindromePartitioning {
    /**
     * 参考：http://blog.csdn.net/ljphhj/article/details/22573983
     * http://blog.csdn.net/yutianzuijin/article/details/16850031
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return result;

        List<String> list = new ArrayList<String>();
        partition(result, list, s);

        return result;
    }

    private void partition(List<List<String>> result, List<String> list, String s) {
        if (s.equals("")) {
            result.add(new ArrayList<String>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            if (isPalindrome(pre)) {
                list.add(pre);
                partition(result, list, s.substring(i));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() <= 1)
            return true;

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
