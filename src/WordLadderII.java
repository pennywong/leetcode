import java.util.*;

/**
 * https://oj.leetcode.com/problems/word-ladder-ii/
 * <p/>
 * Created by Penny on 2015/01/27
 */
public class WordLadderII {
    /**
     * 参考：https://oj.leetcode.com/discuss/20517/share-my-java-solution
     * http://www.blogjava.net/menglee/archive/2014/01/02/408381.html
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new LinkedList<List<String>>();

        if (start == null || end == null || start.length() != end.length() || start.equals(end))
            return result;

        LinkedList<String> queue = new LinkedList<String>();
        String lastWordInLevel = start;

        queue.add(start);
        int level = 0;

        dict.add(end);
        dict.remove(start);

        Map<String, List<String>> preMap = new HashMap<String, List<String>>();
        Map<String, Integer> wordLevel = new HashMap<String, Integer>();

        while (!queue.isEmpty()) {
            String word = queue.poll();
            dict.remove(word);

            if (word.equals(end))
                break;

            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original)
                        continue;
                    chars[i] = c;
                    String nextWord = new String(chars);

                    if (dict.contains(nextWord)) {
                        if (!wordLevel.containsKey(nextWord)) {
                            wordLevel.put(nextWord, level + 1);
                            queue.add(nextWord);
                        }
                        if (wordLevel.get(nextWord) < (level + 1)) {
                            continue;
                        }
                        List<String> preList = preMap.containsKey(nextWord) ? preMap.get(nextWord) : (new LinkedList<String>());
                        preList.add(word);
                        preMap.put(nextWord, preList);
                    }

                }
                chars[i] = original;
            }

            if (word.equals(lastWordInLevel)) {
                lastWordInLevel = queue.peekLast();
                level++;
            }
        }

        LinkedList<String> curRet = new LinkedList<String>();
        curRet.add(end);
        buildPath(preMap, start, end, curRet, result);

        return result;
    }

    private void buildPath(Map<String, List<String>> preMap, String start, String end, LinkedList<String> curRet, List<List<String>> rets) {
        if (end.equals(start)) {
            List<String> newRet = new LinkedList<String>(curRet);
            rets.add(newRet);
            return;
        }
        List<String> list = preMap.get(end);
        if (list == null) return;
        for (String preWord : list) {
            curRet.addFirst(preWord);
            buildPath(preMap, start, preWord, curRet, rets);
            curRet.removeFirst();
        }
    }
}
