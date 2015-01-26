import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * <p/>
 * Created by Penny on 2015/01/19
 */
public class SubstringWithConcatenationOfAllWords {
    /**
     * 参考：http://www.cnblogs.com/panda_lin/archive/2013/10/30/substring_with_concatenation_of_all_words.html
     */
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new LinkedList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return list;

        int size = L[0].length();
        Map<String, Integer> words = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            Integer count = words.get(L[i]);
            if (count == null)
                count = 1;
            else
                count++;
            words.put(L[i], count);
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <= (S.length() - L.length * size); i++) {
            map.clear();
            int j = 0;
            for (; j < L.length; j++) {
                String string = S.substring(i + j * size, i + (j + 1) * size);
                Integer count = words.get(string);
                if (count == null)
                    break;
                Integer x = map.get(string);
                if (x == null)
                    x = 1;
                else
                    x++;
                if (x > count)
                    break;
                map.put(string, x);
            }

            if (j == L.length)
                list.add(i);
        }

        return list;
    }
}
