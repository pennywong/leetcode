import java.util.*;

/**
 * https://oj.leetcode.com/problems/word-ladder/
 * <p/>
 * Created by Penny on 2015/01/27
 */
public class WordLadder {
    /**
     * 参考：http://blog.csdn.net/yutianzuijin/article/details/12887747
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() != end.length() || start.equals(end))
            return 0;

        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        queue.add(start);
        map.put(start, 1);

        while (!queue.isEmpty()) {
            String string = queue.poll();
            int step = map.get(string);
            for (int i = 0; i < string.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (string.charAt(i) == c)
                        continue;
                    StringBuilder stringBuilder = new StringBuilder(string);
                    stringBuilder.setCharAt(i, c);

                    String s = stringBuilder.toString();
                    if (s.equals(end))
                        return step + 1;
                    if (dict.contains(s) && !map.containsKey(s)) {
                        map.put(s, step + 1);
                        queue.add(s);
                    }
                }
            }
        }

        return 0;
    }
}
