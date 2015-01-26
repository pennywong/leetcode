import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/text-justification/
 * <p/>
 * Created by Penny on 2015/01/22
 */
public class TextJustification {
    /**
     * 参考：http://blog.csdn.net/sunbaigui/article/details/8981336
     * http://www.cnblogs.com/x1957/p/3522461.html
     */
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new LinkedList<String>();
        int len = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if ((len + words[i].length() + i - start) > L) {
                list.add(justify(words, start, i - 1, len, L));
                start = i;
                len = 0;
            }

            len += words[i].length();
        }
        list.add(last(words, start, words.length - 1, len, L));

        return list;
    }

    private String justify(String[] words, int start, int end, int len, int L) {
        int n = end - start;
        int spaces = L - len;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= (end - start); i++) {
            stringBuilder.append(words[start + i]);
            int count;
            if (spaces == 0)
                count = 0;
            else if (n == 0)
                count = spaces;
            else {
                count = spaces / n;
                if (spaces % n != 0)
                    count++;
            }
            for (int j = 0; j < count; j++)
                stringBuilder.append(" ");

            spaces -= count;
            n--;
        }

        return stringBuilder.toString();
    }

    private String last(String[] words, int start, int end, int len, int L) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[start]);
        for (int i = start + 1; i <= end; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(words[i]);
        }

        for (int i = 0; i < (L - len - (end - start)); i++)
            stringBuilder.append(" ");

        return stringBuilder.toString();
    }
}
