import java.util.LinkedList;

/**
 * https://oj.leetcode.com/problems/simplify-path/
 * <p/>
 * Created by Penny on 2015/01/23
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "/";

        LinkedList<String> list = new LinkedList<String>();
        String[] strings = path.split("/");
        for (String string : strings) {
            if (string.equals(".") || string.equals(""))
                continue;
            if (string.equals("..")) {
                if (!list.isEmpty())
                    list.removeLast();
            } else
                list.add(string);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append("/");
            stringBuilder.append(string);
        }

        if (stringBuilder.length() == 0)
            stringBuilder.append("/");

        return stringBuilder.toString();
    }
}
