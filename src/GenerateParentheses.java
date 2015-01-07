import java.util.*;

/**
 * https://oj.leetcode.com/problems/generate-parentheses/
 * <p/>
 * Created by Penny on 2015/01/07
 */
public class GenerateParentheses {
    /**
     * 有更好的方式：http://blog.csdn.net/yutianzuijin/article/details/13161721
     */
    public List<String> generateParenthesis(int n) {
        Map<String, String> map = new HashMap<String, String>();
        if (n > 0) {
            map.put("()", "()");
            for (int i = 2; i <= n; i++) {
                Iterator<String> iterator = map.values().iterator();
                map = new HashMap<String, String>();
                while (iterator.hasNext()) {
                    String string = iterator.next();
                    for (int j = 0; j < string.length(); j++) {
                        String s = string.substring(0, j) + "()" + string.substring(j, string.length());
                        map.put(s, s);
                    }
                }
            }
        }

        return new ArrayList<String>(map.values());
    }
}
