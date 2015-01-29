import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 * <p/>
 * Created by Penny on 2015/01/26
 */
public class RestoreIPAddresses {
    /**
     * 参考：http://blog.csdn.net/harryhuang1990/article/details/27958089
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();

        if (s == null || s.length() < 4 || s.length() > 12)
            return result;

        List<String> list = new LinkedList<String>();
        restoreIpAddresses(1, 0, s, list, result);
        return result;
    }

    private void restoreIpAddresses(int index, int start, String s, List<String> list, List<String> result) {
        if (start == s.length()) {
            if (index == 5) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(list.get(0));
                for (int i = 1; i < 4; i++)
                    stringBuilder.append(".").append(list.get(i));
                result.add(stringBuilder.toString());
            }
            return;
        }

        for (int k = 1; k <= 3 && start + k - 1 < s.length(); k++) {
            String num = s.substring(start, start + k);
            if (isValid(num)) {
                List<String> temp = new LinkedList<String>(list);
                temp.add(num);
                restoreIpAddresses(index + 1, start + k, s, temp, result);
            }
        }
    }

    private boolean isValid(String num) {
        if (num.length() < 1 || num.length() > 3)
            return false;
        int i = Integer.parseInt(num);
        if (num.length() == 1 && i >= 0 && i <= 9)
            return true;
        if (num.length() == 2 && i >= 10 && i <= 99)
            return true;
        if (num.length() == 3 && i >= 100 && i <= 255)
            return true;
        return false;
    }
}
