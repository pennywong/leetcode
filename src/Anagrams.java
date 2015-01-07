import java.util.*;

/**
 * https://oj.leetcode.com/problems/anagrams/
 * <p/>
 * Created by Penny on 2014/12/18
 */
public class Anagrams {
    /**
     * Anagrams是指两个字符串的字符的种类和数量一样，顺序可以不一样
     * <p/>
     * 方法可以对字符串的字符进行排序，如果相同则是结果
     * <p/>
     * 更快的方法应该是直接对字符串的字符进行一个计数，得出字符串的唯一编码，然后进行比较，从而减少排序的时间
     */
    public List<String> anagrams(String[] strs) {
        List<String> result = new LinkedList<String>();

        if (strs == null || strs.length <= 1)
            return result;

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);

            List<String> list = map.get(temp);
            if (list == null) {
                list = new ArrayList<String>();
                map.put(temp, list);
            }
            list.add(str);
        }

        for (List<String> list : map.values()) {
            if (list.size() > 1)
                result.addAll(list);
        }

        return result;
    }
}
